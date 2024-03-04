package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RecipeSpecification {


        public static Specification<RecipeEntity> searchRecipe(String search){
            return (root, query, criteriaBuilder) -> {
                String pattern = "%" + search.toLowerCase() + "%";
                return criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), pattern)
                );
            };
        }


    }

