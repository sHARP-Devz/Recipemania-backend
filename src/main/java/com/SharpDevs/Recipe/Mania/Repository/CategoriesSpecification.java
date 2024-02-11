package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import static com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification.likePattern;

public class CategoriesSpecification {

    public static Specification<CategoriesDto> filterCategories(String title){
        return ((root, query, criteriaBuilder) -> {
            Predicate titlePredicate = criteriaBuilder.like(root.get("title"), StringUtils.isBlank(title) ? likePattern("") : title);
            return criteriaBuilder.and(titlePredicate);
        });
    }

    public static Specification<CategoriesDto> searchCategories(String search){
        return ((root, query, criteriaBuilder) -> {
            Predicate titlePredicate = criteriaBuilder.like(root.get("title"),  likePattern(search));
            return criteriaBuilder.or(titlePredicate);
        });
    }


}
