package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification;
import com.SharpDevs.Recipe.Mania.Service.RecipeSearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeSearchServiceImpl implements RecipeSearchService {
    private final RecipeRepository recipeRepository;


    private final RecipeSpecification recipeSpecification;

    public List<RecipeDto> searchRecipes (String search){
        final Specification<RecipeDto> specification = recipeSpecification.searchRecipe(search);
        final List<RecipeDto> recipeOperations = recipeRepository.findAll(specification);

        return recipeOperations;
    }
}
