package com.SharpDevs.Recipe.Mania.domain.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "icons")
    @NotBlank(message = "Icons cannot be blank")
    private String icons;

    @Column(name = "title", unique = true)
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(name = "permLink")
    @NotBlank(message = "permLink cannot be blank")
    private String permLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "category")
    private Set<RecipeEntity> recipes;
}
