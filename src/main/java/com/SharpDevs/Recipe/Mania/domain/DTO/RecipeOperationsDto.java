package com.SharpDevs.Recipe.Mania.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RecipeOperationsDto {

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

    private MultipartFile featuredImage;

    private Long categoryId;

    private Long userId;


}
