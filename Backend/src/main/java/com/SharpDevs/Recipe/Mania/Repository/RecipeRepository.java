package com.SharpDevs.Recipe.Mania.Repository;


import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {

    boolean existsById(Long id);
    Optional<RecipeEntity> findById(Long aLong);
}
