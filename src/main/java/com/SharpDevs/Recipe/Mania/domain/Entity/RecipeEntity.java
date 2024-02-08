package com.SharpDevs.Recipe.Mania.domain.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe")
@Data
@NoArgsConstructor
public class RecipeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "permlink")
    private String permLink;

    @Column(name = "difficulty")
    private String difficult;

    @Column (name = "prepare_time")
    private String prepareTime;

    @Column (name = "cooking_time")
    private String cookingTime;

    @Column (name ="serves")
    private String serves;

    @Column (name = "description")
    private String descriptions;

    @Column (name = "video_link")
    private String videoLink;

    @Column (name = "direction")
    private String direction;

    @Column (name = "meta_description")
    private String metaDescription;

    @Column (name = "featured_image")
    private String featured_image;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user", referencedColumnName =  "user_id")
    private UserEntity user;

}
