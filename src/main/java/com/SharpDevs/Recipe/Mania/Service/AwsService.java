package com.SharpDevs.Recipe.Mania.Service;

import com.amazonaws.HttpMethod;

import java.util.List;

public interface AwsService {

    List<String> listAllObjects();

    String deleteFile(String fileName);

    public String generateUploadUrl(String filename, HttpMethod http);

    public String generateDownloadUrl(String filename, HttpMethod http);

}
