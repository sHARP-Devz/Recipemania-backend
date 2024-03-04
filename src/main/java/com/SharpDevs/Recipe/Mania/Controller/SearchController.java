package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.RecipeSearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SearchController {

    private final RecipeSearchService searchService;

    @GetMapping("/user/recipe/search?search=")
    public ResponseEntity<Iterable<RecipeOperationsDto>> search(@RequestParam String search){
        Iterable<RecipeOperationsDto> recipeOperations = searchService.searchRecipes(search);
        return ResponseEntity.ok(recipeOperations);
    }
}
