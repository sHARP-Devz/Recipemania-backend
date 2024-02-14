package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.SearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/recipe")
@CrossOrigin(origins = "*")
public class SearchController {
    @Autowired
    private final SearchService searchService;

    @GetMapping("/filterRecipe")
    public ResponseEntity<List<RecipeDto>> getRecipes
            (@RequestParam(required = false) String title){
        return ResponseEntity.ok(searchService.findAllRecipes(title));
    }

    @GetMapping("/searchKeyword")
    public ResponseEntity<List<RecipeDto>> search(@RequestParam String search){
        return ResponseEntity.ok(searchService.searchRecipe(search));
    }


}
