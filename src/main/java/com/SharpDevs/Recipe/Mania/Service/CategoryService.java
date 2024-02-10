package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    public ResponseEntity<HttpStatus> createCategory (Long userId, CategoryDto categoryDto);
}
