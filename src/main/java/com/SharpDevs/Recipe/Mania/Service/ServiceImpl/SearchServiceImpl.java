package com.SharpDevs.Recipe.Mania.Service.ServiceImpl;

import com.SharpDevs.Recipe.Mania.Repository.CategoriesRepository;
import com.SharpDevs.Recipe.Mania.Repository.CategoriesSpecification;
import com.SharpDevs.Recipe.Mania.Repository.RecipeRepository;
import com.SharpDevs.Recipe.Mania.Repository.RecipeSpecification;
import com.SharpDevs.Recipe.Mania.Service.SearchService;
import com.SharpDevs.Recipe.Mania.domain.DTO.CategoriesDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
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
