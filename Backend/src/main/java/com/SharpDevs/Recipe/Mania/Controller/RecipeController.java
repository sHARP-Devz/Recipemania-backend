package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.RecipeService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    @PostMapping(path = "/recipe")
    public ResponseEntity addRecipe(@RequestBody()RecipeDto recipeDto){
        return new ResponseEntity(recipeService.addRecipe(recipeDto), HttpStatus.CREATED);
    }
}
