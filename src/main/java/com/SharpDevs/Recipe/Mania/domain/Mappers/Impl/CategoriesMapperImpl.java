package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoriesEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriesMapperImpl implements Mapper<CategoriesEntity, CategoriesDto> {

    private final ModelMapper modelMapper;
    @Override
    public CategoriesDto mapTo(CategoriesEntity categoriesEntity) {
        return modelMapper.map(categoriesEntity, CategoriesDto.class);
    }

    @Override
    public CategoriesEntity mapFrom(CategoriesDto categoriesDto) {
        return modelMapper.map(categoriesDto, CategoriesEntity.class);
    }

    @Override
    public Iterable<CategoriesDto> mapListTo(Iterable<CategoriesEntity> a) {
        return null;
    }
}
