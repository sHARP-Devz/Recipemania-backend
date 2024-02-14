package com.SharpDevs.Recipe.Mania.domain.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RecipeDto {

    private String  id;

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

    private Long categoryId;
}
