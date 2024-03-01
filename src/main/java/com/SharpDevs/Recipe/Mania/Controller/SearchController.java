package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.RecipeSearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SearchController {

    private final RecipeSearchService searchService;

    @GetMapping("/recipe/search")
    public ResponseEntity<List<RecipeDto>> search(@RequestParam String search){
        return ResponseEntity.ok(searchService.searchRecipes(search));
    }
}
