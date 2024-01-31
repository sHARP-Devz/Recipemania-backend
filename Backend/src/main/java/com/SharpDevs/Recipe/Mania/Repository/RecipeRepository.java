package com.SharpDevs.Recipe.Mania.Repository;


import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {

}
