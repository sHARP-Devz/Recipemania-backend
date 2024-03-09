package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface RecipeService {
    public ResponseEntity<RecipeDto> addRecipe(RecipeOperationsDto recipeDto);

//    public ResponseEntity<RecipeDto> addRecipe(RecipeOperationsDto recipeOperationsDto, MultipartFile recipePicture);

    public ResponseEntity<Iterable<RecipeOperationsDto>> getAllRecipe();

    public ResponseEntity<RecipeOperationsDto> getRecipe(Long id);

    public ResponseEntity<RecipeOperationsDto> updateRecipe (Long id, RecipeOperationsDto recipeDto);


    @Transactional
    ResponseEntity<HttpStatus> deleteRecipe(Long id);
}
