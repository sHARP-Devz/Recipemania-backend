package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.SignUpDto;
import com.SharpDevs.Recipe.Mania.domain.DTO.UpdateUserDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class SignUpMapperImpl implements Mapper<UserEntity, SignUpDto> {

    private ModelMapper modelMapper;
    @Override
    public SignUpDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, SignUpDto.class);
    }

    @Override
    public UserEntity mapFrom(SignUpDto signUpDto) {
        return modelMapper.map(signUpDto,UserEntity.class);
    }
}
