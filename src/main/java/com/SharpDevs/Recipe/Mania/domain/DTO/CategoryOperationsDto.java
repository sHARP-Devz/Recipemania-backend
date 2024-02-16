package com.SharpDevs.Recipe.Mania.domain.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryOperationsDto {
    private String id;

    private String icons;

    private String title;

    private String permLink;

    private Long userId;

    private Long categoryId;

}
