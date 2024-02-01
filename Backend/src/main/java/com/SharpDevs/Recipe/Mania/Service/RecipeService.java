package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

public interface RecipeService {
    public ResponseEntity<RecipeDto> addRecipe(RecipeDto recipeDto);

    public ResponseEntity<Iterable<RecipeDto>> getAllRecipe();

    public ResponseEntity<RecipeDto> getRecipe(String id);

    public ResponseEntity<RecipeDto> updateRecipe (String id, RecipeDto recipeDto);


    @Transactional
    ResponseEntity<RecipeDto> deleteRecipe(Long id);
}
