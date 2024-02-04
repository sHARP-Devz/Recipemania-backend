package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.BlogsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.BlogsEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogsMapperImpl implements Mapper<BlogsEntity, BlogsDto> {
    private final ModelMapper modelMapper;

    @Override
    public BlogsDto mapTo(BlogsEntity blogsEntity) {
        return modelMapper.map(blogsEntity, BlogsDto.class);
    }

    @Override
    public BlogsEntity mapFrom(BlogsDto blogsDto) {
        return modelMapper.map(blogsDto, BlogsEntity.class);
    }

    @Override
    public Iterable<BlogsDto> mapListTo(Iterable<BlogsEntity> a) {
        return null;
    }
}
