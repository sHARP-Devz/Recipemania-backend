package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification;
import com.SharpDevs.Recipe.Mania.Service.SearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final RecipeSpecification recipeSpecification;
    private final RecipeRepository recipeRepository;

    @Override
    public List<RecipeOperationsDto> findAllRecipes(String title) {
        final Specification<RecipeOperationsDto> specification = recipeSpecification.filterRecipe(title);
        final List<RecipeOperationsDto> recipes = recipeRepository.findAll(specification);
        return recipes;
    }

    @Override
    public List<RecipeOperationsDto> searchRecipe(String search) {
        final Specification<RecipeOperationsDto> specification = recipeSpecification.searchRecipe(search);
        final List<RecipeOperationsDto> recipeDtos = recipeRepository.findAll(specification);
        return recipeDtos;
    }



}
