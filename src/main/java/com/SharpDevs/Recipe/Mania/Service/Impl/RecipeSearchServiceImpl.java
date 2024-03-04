package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Exception.SearchNotFoundException;
import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification;
import com.SharpDevs.Recipe.Mania.Service.RecipeSearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RecipeSearchServiceImpl implements RecipeSearchService {
    private final RecipeRepository recipeRepository;

    private final Mapper<RecipeEntity, RecipeOperationsDto> recipeOperationsMapper;
    private final RecipeSpecification recipeSpecification;

    public Iterable<RecipeOperationsDto> searchRecipes(String search){
        try {
            final Specification<RecipeEntity> specification = recipeSpecification.searchRecipe(search);
            final Iterable<RecipeEntity> recipeOperations = recipeRepository.findAll(specification);
            return recipeOperationsMapper.mapListTo(recipeOperations);
        } catch (SearchNotFoundException e) {
            throw new SearchNotFoundException( search + "recipe is not present");
        }
    }
}
