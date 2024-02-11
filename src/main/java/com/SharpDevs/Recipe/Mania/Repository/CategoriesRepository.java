package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoriesEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long>, JpaSpecificationExecutor<CategoriesDto> {
    List<CategoriesEntity> findAll();

    List<CategoriesDto> findAll(Specification<CategoriesDto> spec);

    Optional<CategoriesEntity> findById(Long id);
    boolean existsById(Long id);
}
