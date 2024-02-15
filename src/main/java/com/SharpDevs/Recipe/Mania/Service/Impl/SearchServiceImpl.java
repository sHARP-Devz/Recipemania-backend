package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification;
import com.SharpDevs.Recipe.Mania.Service.SearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
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
    public List<RecipeDto> findAllRecipes(String title) {
        final Specification<RecipeDto> specification = recipeSpecification.filterRecipe(title);
        final List<RecipeDto> recipes = recipeRepository.findAll(specification);
        return recipes;
    }

    @Override
    public List<RecipeDto> searchRecipe(String search) {
        final Specification<RecipeDto> specification = recipeSpecification.searchRecipe(search);
        final List<RecipeDto> recipeDtos = recipeRepository.findAll(specification);
        return recipeDtos;
    }



}
