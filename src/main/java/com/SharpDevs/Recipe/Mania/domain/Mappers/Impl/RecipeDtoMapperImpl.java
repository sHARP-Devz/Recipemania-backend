package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.Repository.CategoryRepository;
import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class RecipeDtoMapperImpl implements Mapper<RecipeEntity, RecipeDto> {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public RecipeDto mapTo(RecipeEntity recipeEntity) {
        return modelMapper.map(recipeEntity, RecipeDto.class);
    }

    @Override
    public RecipeEntity mapFrom(RecipeDto recipeDto) {
        return modelMapper.map(recipeDto, RecipeEntity.class);
    }


    public Iterable<RecipeDto> mapListTo(Iterable<RecipeEntity> recipeEntityIterable) {
        return StreamSupport.stream(recipeEntityIterable.spliterator(),false)
                .map(recipeEntity ->
                        modelMapper.map(recipeEntity, RecipeDto.class)
                ).collect(Collectors.toList());
    }




}

