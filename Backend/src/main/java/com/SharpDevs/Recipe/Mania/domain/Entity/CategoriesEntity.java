package com.SharpDevs.Recipe.Mania.domain.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "newsletter")
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "icons")
    @NotBlank(message = "Icons cannot be blank")
    private String icons;

    @Column(name = "title")
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(name = "permLink")
    @NotBlank(message = "permLink cannot be blank")
    private String permLink;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "RecipeEntity")
    private RecipeEntity recipeEntity;
}
