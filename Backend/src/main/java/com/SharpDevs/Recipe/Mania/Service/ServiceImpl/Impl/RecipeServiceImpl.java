package com.SharpDevs.Recipe.Mania.Service.ServiceImpl.Impl;

import com.SharpDevs.Recipe.Mania.Service.RecipeService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RecipeServiceImpl implements RecipeService {

    @Override
    public ResponseEntity<RecipeDto> addRecipe(RecipeDto recipeDto) {

        RecipeEntity
        return null;
    }

    @Override
    public ResponseEntity<List<RecipeDto>> getAllRecipe() {
        return null;
    }

    @Override
    public ResponseEntity<RecipeDto> getRecipe(String id) {
        return null;
    }

    @Override
    public ResponseEntity<RecipeDto> updateRecipe(String id, RecipeDto recipeDto) {
        return null;
    }

    @Override
    public ResponseEntity<RecipeDto> deleteRecipe(String id) {
        return null;
    }
}
