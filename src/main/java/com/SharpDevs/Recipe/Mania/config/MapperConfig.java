package com.SharpDevs.Recipe.Mania.config;

import com.SharpDevs.Recipe.Mania.Repository.CategoryRepository;
import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeOperationsDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MapperConfig {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        return modelMapper;
    }
}
