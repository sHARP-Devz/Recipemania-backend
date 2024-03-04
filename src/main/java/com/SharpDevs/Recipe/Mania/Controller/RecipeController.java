package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.RecipeService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RecipeController {

  private final RecipeService recipeService;
    @PostMapping(path = "/user/recipe")
    public ResponseEntity addRecipe(@RequestBody() RecipeOperationsDto recipeDto){
        return new ResponseEntity(recipeService.addRecipe(recipeDto), HttpStatus.CREATED);
    }

@GetMapping(path = "/recipe")
    public ResponseEntity<Iterable<RecipeOperationsDto>> getAllRecipe(){
        return recipeService.getAllRecipe();
}

@GetMapping(path = "/recipe/{id}")
    public ResponseEntity<RecipeOperationsDto> getRecipe(@PathVariable Long id){
        return recipeService.getRecipe(id);
    }

    @PutMapping(path = "/user/recipe/{id}")
    public ResponseEntity<RecipeOperationsDto> updateRecipe(@PathVariable Long id, @RequestBody RecipeOperationsDto recipeDto){
        return recipeService.updateRecipe(id,recipeDto);
    }

    @DeleteMapping(path = "/user/recipe/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe (@PathVariable Long id){
        return recipeService.deleteRecipe(id);
    }

}
