package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;

import java.util.List;

public interface SearchService {
    List<RecipeOperationsDto> findAllRecipes(String title);

    List<RecipeOperationsDto> searchRecipe(String search);

}
