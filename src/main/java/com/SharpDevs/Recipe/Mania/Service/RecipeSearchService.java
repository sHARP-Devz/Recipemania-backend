package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;

import java.util.List;

public interface RecipeSearchService {

    List<RecipeDto> searchRecipes(String search);
}
