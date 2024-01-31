package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecipeMapperImpl implements Mapper<RecipeEntity, RecipeDto> {

    private final ModelMapper modelMapper;

    @Override
    public RecipeDto mapTo(RecipeEntity recipeEntity) {
        return modelMapper.map(recipeEntity,RecipeDto.class);
    }

    @Override
    public RecipeEntity mapFrom(RecipeDto recipeDto) {
        return modelMapper.map(recipeDto, RecipeEntity.class);
    }
}
