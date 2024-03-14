package com.SharpDevs.Recipe.Mania.domain.DTO;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@Data
@RequiredArgsConstructor
public class BlogsDto {

    private Date created;

    private Date updated;

    private String title;

    private String permLink;

    private String shortDescription;

    private String description;

    private String image;

    private String metaDescription;
}
