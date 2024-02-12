package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;

import java.util.List;

public interface SearchService {
    List<RecipeDto> findAllRecipes(String title);

    List<RecipeDto> searchRecipe(String search);

    List<CategoriesDto> findAllCategories(String title);

    List<CategoriesDto> searchCategories(String search);
}
