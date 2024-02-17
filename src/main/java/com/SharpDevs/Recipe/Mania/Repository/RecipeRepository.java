package com.SharpDevs.Recipe.Mania.Repository;


import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Long>, JpaSpecificationExecutor<RecipeOperationsDto> {

    boolean existsById(Long id);
    Optional<RecipeEntity> findById(Long aLong);

    List<RecipeOperationsDto> findAll(Specification<RecipeOperationsDto> spec);
}
