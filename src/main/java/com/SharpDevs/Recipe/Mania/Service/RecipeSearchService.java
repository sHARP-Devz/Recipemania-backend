package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;

public interface RecipeSearchService {

    Iterable<RecipeOperationsDto> searchRecipes(String search);
}
