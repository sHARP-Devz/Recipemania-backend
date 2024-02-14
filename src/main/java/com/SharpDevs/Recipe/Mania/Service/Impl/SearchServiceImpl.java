<<<<<<< HEAD:src/main/java/com/SharpDevs/Recipe/Mania/Service/ServiceImpl/SearchServiceImpl.java
package com.SharpDevs.Recipe.Mania.Service.ServiceImpl;
=======
package com.SharpDevs.Recipe.Mania.Service.Impl;
>>>>>>> 762170b072166f6b1712348c93e6ea13aa161bda:src/main/java/com/SharpDevs/Recipe/Mania/Service/Impl/SearchServiceImpl.java

import com.SharpDevs.Recipe.Mania.Repository.CategoriesRepository;
import com.SharpDevs.Recipe.Mania.Repository.CategoriesSpecification;
import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification;
import com.SharpDevs.Recipe.Mania.Service.SearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final RecipeSpecification recipeSpecification;

    private final CategoriesSpecification categoriesSpecification;
    private final RecipeRepository recipeRepository;

    private final CategoriesRepository categoriesRepository;
    @Override
    public List<RecipeDto> findAllRecipes(String title) {
        final Specification<RecipeDto> specification = recipeSpecification.filterRecipe(title);
        final List<RecipeDto> recipes = recipeRepository.findAll(specification);
        return recipes;
    }

    @Override
    public List<RecipeDto> searchRecipe(String search) {
        final Specification<RecipeDto> specification = recipeSpecification.searchRecipe(search);
        final List<RecipeDto> recipeDtos = recipeRepository.findAll(specification);
        return recipeDtos;
    }

    @Override
    public List<CategoriesDto> findAllCategories(String title) {
        final Specification<CategoriesDto> specification = categoriesSpecification.filterCategories(title);
        final List<CategoriesDto> categories = categoriesRepository.findAll(specification);
        return categories;
    }

    @Override
    public List<CategoriesDto> searchCategories(String search) {
        final Specification<CategoriesDto> specification = categoriesSpecification.searchCategories(search);
        final List<CategoriesDto> categoriesDtoList = categoriesRepository.findAll(specification);
        return categoriesDtoList;
    }
}
