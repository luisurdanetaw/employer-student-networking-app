package com.example.finalprojectdbdesign.repository;

import com.example.finalprojectdbdesign.model.Employer;
import com.example.finalprojectdbdesign.model.JobPosting;
import com.example.finalprojectdbdesign.model.Student;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.JobName;
import java.util.*;

@Getter
@Repository
public class FakeDB {
    private JobPosting[] jobs = {
            new JobPosting("usmc@gmail.com", "Explosive Ordnance Disposal", 270000, "CA", "test"),
            new JobPosting("usmc@gmail.com", "Infantry", 30000, "CA", "test job")};

    private Student[] students = {
            new Student("John", "jdawg123", "john@gmail.com", "123", "Westpoint", "Finance", 3.5F)
    };

    private Employer[] employers = {
            new Employer("Blackwater", "bwater123", "blackwater@gmail.com", "123", "Defense", "NC"),
            new Employer("USMC", "thecorps123", "usmc@gmail.com", "123", "Defense", "VA")
    };

    private List<Employer> fakeEmployerTable = new ArrayList<>(Arrays.asList(employers));

    private List<Student> fakeStudentTable = new ArrayList<>(Arrays.asList(students));

    private List<JobPosting> fakeJobPostingTable = new ArrayList<>(Arrays.asList(jobs));

    public List<Employer> searchEmployerByName(String name){
        if(name == null) return getFakeEmployerTable();
        List<Employer> employersFound = new ArrayList<Employer>();
        for(Employer e: fakeEmployerTable){
            if(e.getName().contains(name))
                employersFound.add(e);
        }
        return employersFound;
    }

    public Employer getEmployerByUsername(String username) {

        for(Employer e: fakeEmployerTable){
            if(e.getUsername().equals(username))
                return e;
        }
        throw new IllegalStateException("employer not found");
    }

    public void saveJob(JobPosting job) {
        fakeJobPostingTable.add(job);
    }

    public void addStudent(Student student) {
        if(!emailValid("STUDENT", student.getEmail())){
            throw new IllegalStateException("Email taken");
        }
        fakeStudentTable.add(student);
    }

    public void addEmployer(Employer employer) {
        if(!emailValid("EMPLOYER", employer.getEmail())){
            throw new IllegalStateException("Email taken");
        }
        fakeEmployerTable.add(employer);
    }

    //validation can be improved a lot.
    public boolean emailValid(String userType, String email){
        if(userType.equals("STUDENT")){
            for(Student s : fakeStudentTable){
                if(s.getEmail().equals(email))
                    return false;
            }
        }
        if(userType.equals("EMPLOYER")){
            for(Employer e : fakeEmployerTable){
                if(e.getEmail().equals(email))
                    return false;
            }
        }
        return true;
    }

    public Student findStudentByEmail(String email) {
        for(Student s : fakeStudentTable){
            if(s.getEmail().equals(email)){
                return s;
            }
        }
        return null;
    }

    public Employer findEmployerByEmail(String email) {
        for(Employer e : this.fakeEmployerTable){
            if(e.getEmail().equals(email)){
                return e;
            }
        }
        return null;
    }

    public List<Student> searchStudentByName(String name) {
        if(Objects.isNull(name)) return getFakeStudentTable();

        List<Student> studentsFound = new ArrayList<>();
        for(Student s : fakeStudentTable){
            if(s.getName().toLowerCase().contains(name.toLowerCase()))
                studentsFound.add(s);
        }
        if(studentsFound.isEmpty()) throw new IllegalStateException("NO RESULTS");
        return studentsFound;


    }
    public Student getStudentByUsername(String username) {
        for(Student s : fakeStudentTable){
            if(s.getUsername().toLowerCase().contains(username.toLowerCase()))
                return s;
        }
        throw new IllegalStateException("STUDENT NOT FOUND");
    }
}
