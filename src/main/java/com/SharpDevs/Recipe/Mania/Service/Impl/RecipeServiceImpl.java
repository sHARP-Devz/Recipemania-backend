package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Repository.CategoryRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.Service.RecipeService;
import com.SharpDevs.Recipe.Mania.Utils;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoryEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService  {

   private final Mapper<RecipeEntity,RecipeDto> recipeDtoMapper;

   private final UserRepository userRepository;

   private final CategoryRepository categoryRepository;

   private  final RecipeRepository recipeRepository;
    private final Utils utils;
    @Override
    public ResponseEntity<RecipeDto> addRecipe(Long userId, RecipeDto recipeDto)  {
        try {
            if(userRepository.existsByUserId(userId)){
                UserEntity existingUser = utils.getUser(userId);
                RecipeEntity recipeEntity = recipeDtoMapper.mapFrom(recipeDto);
                if (recipeEntity != null) {
                   CategoryEntity foundCategory =  categoryRepository.findById(recipeDto.getCategoryId()).orElse(null);
                    if(foundCategory!=null){
                        recipeEntity.setCategory(foundCategory);
                    }
                   recipeEntity.setUser(existingUser);
                    RecipeEntity  savedRecipeEntity = recipeRepository.save(recipeEntity);
                    recipeDto =  recipeDtoMapper.mapTo(savedRecipeEntity);
                    return new ResponseEntity<>(recipeDto,HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }else{
                throw new RuntimeException("User does not exist");
            }

        }catch(Exception e){
            throw new RuntimeException(e + "Encountered an error while saving recipe");
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

    public ResponseEntity<RecipeDto> getRecipe(Long user_id) {

            Optional<RecipeEntity> existingRecipe = recipeRepository.findById(user_id);
        return existingRecipe.map(recipeEntity -> {
            RecipeDto recipeDto = recipeDtoMapper.mapTo(recipeEntity);

            return new ResponseEntity<>(recipeDto,HttpStatus.FOUND);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

        @Override
    public ResponseEntity<RecipeDto> updateRecipe(Long user_id, RecipeDto recipeDto) {
        if(recipeRepository.existsById(user_id)){
            return recipeRepository.findById(user_id).map(
                    existingRecipe -> {
                        Optional.ofNullable(recipeDto.getTitle()).ifPresent(existingRecipe::setTitle);
                        Optional.ofNullable(recipeDto.getDescriptions()).ifPresent(existingRecipe::setDescriptions);
                        Optional.ofNullable(recipeDto.getCookingTime()).ifPresent(existingRecipe::setCookingTime);
                        Optional.ofNullable(recipeDto.getDifficult()).ifPresent(existingRecipe::setDifficult);
                        Optional.ofNullable(recipeDto.getDirection()).ifPresent(existingRecipe::setDirection);
                        Optional.ofNullable(recipeDto.getServes()).ifPresent(existingRecipe::setServes);
                        Optional.ofNullable(recipeDto.getMetaDescription()).ifPresent(existingRecipe::setMetaDescription);
                        Optional.ofNullable(recipeDto.getPermLink()).ifPresent(existingRecipe::setPermLink);
                        Optional.ofNullable(recipeDto.getVideoLink()).ifPresent(existingRecipe::setVideoLink);
                        Optional.ofNullable(recipeDto.getPrepareTime()).ifPresent(existingRecipe::setPrepareTime);

                        RecipeDto updatedRecipe = recipeDtoMapper.mapTo(recipeRepository.save(existingRecipe));

                        return new ResponseEntity<>(updatedRecipe,HttpStatus.OK);
                    }
            ).orElseThrow(() -> new RuntimeException("Recipe Did Not Update"));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> deleteRecipe(Long user_id) {
        try {
            recipeRepository.deleteById(user_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception err){
            throw new RuntimeException("Delete failed");
        }

    }

}
