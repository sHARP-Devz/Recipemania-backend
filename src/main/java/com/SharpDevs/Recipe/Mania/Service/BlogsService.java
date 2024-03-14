package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.BlogsDto;
import org.springframework.http.ResponseEntity;

public interface BlogsService {
    ResponseEntity createPost(BlogsDto blogDto);

    ResponseEntity editPost(BlogsDto blogDto);
}
