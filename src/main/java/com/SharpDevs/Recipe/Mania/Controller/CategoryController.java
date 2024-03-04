package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.CategoryService;
import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryOperationsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/user/category")
    public ResponseEntity createCategory(@RequestBody CategoryOperationsDto categoryOperationsDto) {
        return categoryService.createCategory(categoryOperationsDto);
    }

    @GetMapping("/category")
    public ResponseEntity getAllCategory() {
        return categoryService.getAllCategory();
    }
    @GetMapping("/category/{id}")
    public ResponseEntity getAllCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}
