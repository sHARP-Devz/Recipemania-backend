package com.SharpDevs.Recipe.Mania.domain.DTO;

import com.SharpDevs.Recipe.Mania.domain.Entity.CategoryEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RecipeDto {

    private Long id;

    private String title;

    private String permLink;

    private String difficult;

    private String prepareTime;

    private String cookingTime;

    private String serves;

    private String descriptions;

    private String videoLink;

    private String direction;

    private String metaDescription;

    private String featured_image;

    private UserEntity user;

    private CategoryEntity category;
}
