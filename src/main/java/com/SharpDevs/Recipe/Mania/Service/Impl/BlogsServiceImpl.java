package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Repository.BlogsRepository;
import com.SharpDevs.Recipe.Mania.Service.BlogsService;
import com.SharpDevs.Recipe.Mania.domain.DTO.BlogsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.BlogsEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogsServiceImpl  implements BlogsService {

    private final BlogsRepository blogsRepository;

    private final Mapper<BlogsEntity,BlogsDto> blogsDtoMapper;
    @Override
    public ResponseEntity createPost(BlogsDto blogDto) {
        try {
            if (blogDto != null) {
                BlogsEntity newBlogPost = blogsDtoMapper.mapFrom(blogDto);
                BlogsEntity savedBlogPost = blogsRepository.save(newBlogPost);

                return new ResponseEntity(savedBlogPost, HttpStatus.CREATED);
            } else {
                throw new RuntimeException("Failed to Post");
            }
        } catch (Exception ex) {

        }
    return null;
    }

    @Override
    public ResponseEntity editPost(Long blogId, BlogsDto blogDto) {
        return null;
    }


}
