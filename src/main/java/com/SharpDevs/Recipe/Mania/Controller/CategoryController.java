package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.CategoryService;
import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/user/category/{userId}")
    public ResponseEntity createCategory (@RequestBody CategoryDto categoryDto,@PathVariable Long userId){
        return categoryService.createCategory(userId,categoryDto);
    }
}
