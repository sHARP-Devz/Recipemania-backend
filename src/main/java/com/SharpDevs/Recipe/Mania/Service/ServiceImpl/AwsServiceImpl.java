package com.SharpDevs.Recipe.Mania.Service.ServiceImpl;

import com.SharpDevs.Recipe.Mania.Service.AwsService;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    @Override
    public String generateUploadUrl(String filename, HttpMethod http) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 12);
        URL url = s3Client.generatePresignedUrl(bucketName,filename,cal.getTime(),http);
        return url.toString();
    }


    @Override
    public String generateDownloadUrl(String filename, HttpMethod http) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 160);
        URL url = s3Client.generatePresignedUrl(bucketName, filename, cal.getTime(), http);
        return url.toString();
    }

    @Override
    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName,fileName);
        return fileName + "File deleted successfully";
    }

}
