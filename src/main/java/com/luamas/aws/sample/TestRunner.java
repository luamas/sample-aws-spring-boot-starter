package com.luamas.aws.sample;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private AmazonS3 amazonS3;
    @Override
    public void run(String... args) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileUrl = classLoader.getResource("aa");
        PutObjectRequest putObjectRequest = new PutObjectRequest("aaa", "test", new File(fileUrl.getFile()));
        PutObjectResult putObjectResult = amazonS3.putObject(putObjectRequest);
    }
}
