package com.SharpDevs.Recipe.Mania.domain.DTO;

import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class CategoryDto {

    private String icons;

    private String title;

    private String permLink;

    private Set<RecipeEntity> recipes;
}
