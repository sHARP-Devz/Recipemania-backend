package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecipeService {
    public ResponseEntity<RecipeDto> addRecipe(RecipeDto recipeDto);

    public ResponseEntity<List<RecipeDto>> getAllRecipe();

    public ResponseEntity<RecipeDto> getRecipe(String id);

    public ResponseEntity<RecipeDto> updateRecipe (String id, RecipeDto recipeDto);

    public ResponseEntity<RecipeDto> deleteRecipe(String id);
}
