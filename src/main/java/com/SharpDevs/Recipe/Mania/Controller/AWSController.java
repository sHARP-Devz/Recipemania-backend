package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.AwsService;
import com.amazonaws.HttpMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class AWSController {

    @Autowired
    private final AwsService awsService;


    @GetMapping("list")
    public List<String> getAllFiles(){
        return awsService.listAllObjects();
    }


    @PostMapping("/uploadurl")
    public ResponseEntity<String> uploadFileUrl(@RequestParam String extension){
        return ResponseEntity.ok(awsService.generateUploadUrl(UUID.randomUUID() + "." + extension, HttpMethod.PUT));
    }

    @GetMapping("/downloadurl")
    public ResponseEntity<String> downloadFileUrl(@RequestParam String filename){
        return ResponseEntity.ok(awsService.generateDownloadUrl(filename, HttpMethod.GET));
    }

    @DeleteMapping("/delete/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable("filename") String filename){
        return new ResponseEntity<>(awsService.deleteFile(filename), HttpStatus.NO_CONTENT);
    }
}
