package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Exception.FileUploadException;
import com.SharpDevs.Recipe.Mania.Service.AwsService;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AwsServiceImpl implements AwsService {

    @Autowired
    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;


    @Override
    public List<String> listAllObjects() {
        ListObjectsV2Result objectListing = s3Client.listObjectsV2(bucketName);
        System.out.println(objectListing);
        return objectListing.getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }

    public String saveObjects(MultipartFile file) throws IOException{
        String s3Key = generateUniqueKey(file.getOriginalFilename());
        String url = "https://" + bucketName + ".s3.amazonaws.com/" + s3Key;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        try(InputStream inputStream = file.getInputStream()){
            s3Client.putObject(new PutObjectRequest(bucketName, s3Key, inputStream,metadata));
        } catch (FileUploadException e) {
            throw new FileUploadException("File unable to upload");
        }

        return url;
    }

    private String generateUniqueKey(String filename){
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String randomLink = UUID.randomUUID().toString().replaceAll("_","").substring(0, 6);
        return timeStamp + "_" + randomLink +"_" + filename;
    }


    @Override
    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName,fileName);
        return fileName + "File deleted successfully";
    }

}
