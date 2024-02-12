package com.SharpDevs.Recipe.Mania.Service.ServiceImpl.Impl;

import com.SharpDevs.Recipe.Mania.Repository.CategoryRepository;
import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.Service.CategoryService;
import com.SharpDevs.Recipe.Mania.Utils;
import com.SharpDevs.Recipe.Mania.domain.DTO.CategoryDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.CategoryEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    
    private final UserRepository userRepository;

    private final Mapper<CategoryEntity,CategoryDto> categoryMapper;
    @Override
    public ResponseEntity<HttpStatus> createCategory(Long userId, CategoryDto categoryDto) throws RuntimeException{
        try {
            UserEntity foundUser = Utils.getUser(userId,userRepository);
            if(foundUser!=null){
                categoryDto.setUser(foundUser);
            CategoryEntity newCategory = categoryMapper.mapFrom(categoryDto);

                categoryDto = categoryMapper.mapTo(categoryRepository.save(newCategory));
            return new ResponseEntity(categoryDto, HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception err){
            throw new RuntimeException(err + "Error while creating Category");
        }
    }
}