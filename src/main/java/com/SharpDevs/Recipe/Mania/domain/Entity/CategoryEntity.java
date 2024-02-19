package com.SharpDevs.Recipe.Mania.domain.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "icons")
    @NotBlank(message = "Icons cannot be blank")
    private String icons;

    @Column(name = "title", unique = true)
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(name = "permLink")
    @NotBlank(message = "PermLink cannot be blank")
    private String permLink;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @JsonBackReference
    private UserEntity user;

    @ManyToMany(mappedBy = "categories")
    @JsonManagedReference
    private Set<RecipeEntity> recipes;

    public CategoryEntity(String icons, String title, String permLink, UserEntity user) {
        this.icons = icons;
        this.title = title;
        this.permLink = permLink;
        this.user = user;
    }
}