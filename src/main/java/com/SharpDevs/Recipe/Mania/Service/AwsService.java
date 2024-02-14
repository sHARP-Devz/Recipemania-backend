package com.SharpDevs.Recipe.Mania.Service;

import com.amazonaws.HttpMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AwsService {

    List<String> listAllObjects();
    String saveObjects(MultipartFile file) throws IOException;
    String deleteFile(String fileName);

}
