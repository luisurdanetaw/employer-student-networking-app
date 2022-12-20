package com.luisurdaneta.app.fileStorage;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.AWSLambdaException;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.IOUtils;
import com.amazonaws.services.lambda.model.InvokeResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Service
public class StorageService {

    private final AmazonS3 s3;
    private final AWSLambda lambda;

    @Autowired
    public StorageService (AmazonS3 s3, AWSLambda lambda){
        this.s3 = s3;
        this.lambda = lambda;
    }

    public String uploadProfileImageToS3(byte[] originalImg, String key){
        try{
            String functionName = "resizeImgOnUploadToS3";
            String img = BinaryUtils.toBase64(originalImg);

            String payload = "{\"key\": " + key + ", " + "\"image\": " + img + "}";

            InvokeRequest request = new InvokeRequest().withFunctionName(functionName).withPayload(payload);

            InvokeResult result = lambda.invoke(request);
            String response = new String(result.getPayload().array(), Charset.forName("UTF-8"));
            System.out.println("response");
            return response;
        }
        catch(AWSLambdaException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public byte[] downloadProfileImageFromS3(String key) {
        try {
            final String BUCKET_NAME = "profile-pic-bucket-luisurdaneta-personal-project";
            return IOUtils.toByteArray(s3.getObject(BUCKET_NAME, key).getObjectContent());

        } catch (AmazonServiceException | IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}