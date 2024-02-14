package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryOperationsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoryEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CategoryOperationMapper implements Mapper<CategoryEntity, CategoryOperationsDto> {

    private final ModelMapper modelMapper;

    @Override
    public CategoryOperationsDto mapTo(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryOperationsDto.class);
    }

    @Override
    public CategoryEntity mapFrom(CategoryOperationsDto categoryOperationsDto) {
        return modelMapper.map(categoryOperationsDto, CategoryEntity.class);
    }

    @Override
    public List<CategoryOperationsDto> mapListTo(Iterable<CategoryEntity> categoryEntities) {
        return StreamSupport.stream(categoryEntities.spliterator(), false)
                .map(categoryEntity -> modelMapper.map(
                        categoryEntity, CategoryOperationsDto.class
                )).collect(Collectors.toList());
    }


}