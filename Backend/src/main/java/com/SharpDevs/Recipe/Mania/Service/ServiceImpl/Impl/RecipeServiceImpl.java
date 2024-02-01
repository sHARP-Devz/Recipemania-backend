package com.SharpDevs.Recipe.Mania.Service.ServiceImpl.Impl;

import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Service.RecipeService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService  {

   private final Mapper<RecipeEntity,RecipeDto> recipeDtoMapper;

   private  final RecipeRepository recipeRepository;
    @Override
    public ResponseEntity<RecipeDto> addRecipe(RecipeDto recipeDto)  {
        try {
            RecipeEntity recipeEntity = recipeDtoMapper.mapFrom(recipeDto);
            if (recipeEntity != null) {
              RecipeEntity  savedRecipeEntity = recipeRepository.save(recipeEntity);
              recipeDto =  recipeDtoMapper.mapTo(savedRecipeEntity);
                return new ResponseEntity<>(recipeDto,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            throw new RuntimeException("Encountered an error while saving recipe");
        }
    }

    @Override
    public ResponseEntity<Iterable<RecipeDto>> getAllRecipe() {
        try{
            Iterable<RecipeEntity> allRecipeList = recipeRepository.findAll();
            return new ResponseEntity<>(recipeDtoMapper.mapListTo(allRecipeList),HttpStatus.OK);
        }catch (Exception err) {
            throw new RuntimeException("Failed to fetch Recipes");
        }

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
    @Transactional
    public ResponseEntity<RecipeDto> deleteRecipe(Long id) {
        try {
            recipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception err){
            throw new RuntimeException("Delete failed");
        }

    }
}
