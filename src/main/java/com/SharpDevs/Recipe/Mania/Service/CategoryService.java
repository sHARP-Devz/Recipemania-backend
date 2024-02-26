package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryOperationsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<HttpStatus> createCategory(CategoryOperationsDto categoryOperationsDto);

    ResponseEntity<Iterable<CategoryOperationsDto>> getAllCategory();

    ResponseEntity<CategoryDto> getCategory(Long id);
}
