package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.UserDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoryEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CategoryMapperImpl implements Mapper<CategoryEntity, CategoryDto> {

    private final ModelMapper modelMapper;

    @Override
    public CategoryDto mapTo(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDto.class);
    }

    @Override
    public CategoryEntity mapFrom(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto,CategoryEntity.class);
    }

    @Override
    public Iterable<CategoryDto> mapListTo(Iterable<CategoryEntity> categoryEntities) {
        return StreamSupport.stream(categoryEntities.spliterator(), false)
                .map(categoryEntity -> modelMapper.map(
                        categoryEntity, CategoryDto.class
                )).collect(Collectors.toList());
    }


}