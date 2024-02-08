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
@RequestMapping("/api/v1")
public class RecipeController {

  private final RecipeService recipeService;
    @PostMapping(path = "/recipe")
    public ResponseEntity addRecipe(@RequestBody()RecipeDto recipeDto){
        return new ResponseEntity(recipeService.addRecipe(recipeDto), HttpStatus.CREATED);
    }

@GetMapping(path = "/recipe")
    public ResponseEntity<Iterable<RecipeDto>> getAllRecipe(){
        return recipeService.getAllRecipe();
}

@GetMapping(path = "/recipe/{id}")
    public ResponseEntity<RecipeDto> getRecipe(@PathVariable Long id){
        return recipeService.getRecipe(id);
    }

    @PutMapping(path = "/user/recipe/{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable Long id, @RequestBody RecipeDto recipeDto){
        return recipeService.updateRecipe(id,recipeDto);
    }

    @DeleteMapping(path = "/user/recipe/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe (@PathVariable Long id){
        return recipeService.deleteRecipe(id);
    }

}
