package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.Entity.CategoriesEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {
    List<CategoriesEntity> findAll();

    Optional<CategoriesEntity> findById(Long id);
    boolean existsById(Long id);
}
