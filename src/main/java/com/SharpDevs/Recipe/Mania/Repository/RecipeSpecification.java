package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RecipeSpecification {


        public static Specification<RecipeDto> filterRecipe(String title){
            return ((root, query, criteriaBuilder) -> {
                Predicate titlePredicate = criteriaBuilder.like(root.get("title"), StringUtils.isBlank(title) ? likePattern("") : title);
                return criteriaBuilder.and(titlePredicate);
            });
        }

        public static Specification<RecipeDto> searchRecipe(String search){
            return ((root, query, criteriaBuilder) -> {
                Predicate titlePredicate = criteriaBuilder.like(root.get("title"),  likePattern(search));
                return criteriaBuilder.or(titlePredicate);
            });
        }

        public static String likePattern(String value){
            return "%" + value + "%";
        }

}
