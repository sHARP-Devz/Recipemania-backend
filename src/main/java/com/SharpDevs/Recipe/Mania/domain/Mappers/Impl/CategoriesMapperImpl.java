package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoryEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriesMapperImpl implements Mapper<CategoryEntity, CategoryDto> {

    private final ModelMapper modelMapper;
    @Override
    public CategoryDto mapTo(CategoryEntity categoriesEntity) {
        return modelMapper.map(categoriesEntity, CategoryDto.class);
    }

    @Override
    public CategoryEntity mapFrom(CategoryDto categoriesDto) {
        return modelMapper.map(categoriesDto, CategoryEntity.class);
    }

    @Override
    public Iterable<CategoryDto> mapListTo(Iterable<CategoryEntity> a) {
        return null;
    }
}
