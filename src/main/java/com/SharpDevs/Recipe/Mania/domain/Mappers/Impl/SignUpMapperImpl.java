package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.SignUpDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Component
public class SignUpMapperImpl implements Mapper<UserEntity, SignUpDto> {

    private final ModelMapper modelMapper;
    @Override
    public SignUpDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, SignUpDto.class);
    }

    @Override
    public UserEntity mapFrom(SignUpDto signUpDto) {
        return modelMapper.map(signUpDto,UserEntity.class);
    }

    @Override
    public Iterable<SignUpDto> mapListTo(Iterable<UserEntity> a) {
        return null;
    }




}
