package com.example.finalprojectdbdesign.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.lambda.model.AWSLambdaException;
import com.example.finalprojectdbdesign.fileStorage.StorageService;
import com.example.finalprojectdbdesign.model.Student;
import com.example.finalprojectdbdesign.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.apache.http.entity.ContentType.*;

@Service
public class StudentService {
    private final StudentDao studentDao;
    private final StorageService storageService;

    @Autowired
    public StudentService(StudentDao studentDao, StorageService storageService){
        this.studentDao = studentDao;
        this.storageService = storageService;
    }

    public List<Student> searchStudent(String name) throws DataAccessException {
        List<Student> list = studentDao.findStudentsByName(name);
        if(list.isEmpty()) throw new EmptyResultDataAccessException("Result set expected to be greater than 1.", 1);
        return list;
    }

    public Student getStudentPage(String username) throws DataAccessException {
            return studentDao.findStudentByUsername(username);
    }

    public void uploadProfileImage(MultipartFile image, String username) throws IOException {
        if(image.isEmpty()) throw new IllegalStateException("File cannot be empty");
        if(!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_PNG.getMimeType()
        )
                .contains(image.getContentType())){
            throw new IllegalStateException("File must be of the following type: JPEG, GIF or PNG.");
        }
        if(usernameIsValid(username)){
            storageService.uploadProfileImageToS3(image.getBytes(), username);
        }
        else throw new IllegalStateException("Username does not exist ");
    }

    public byte[] downloadProfileImage(String username) {
        if(usernameIsValid(username))
            return storageService.downloadProfileImageFromS3(username);
        else throw new IllegalStateException("Username does not exist");
    }

    private boolean usernameIsValid(String username){
        return !Objects.isNull(getStudentPage(username));
    }
}
