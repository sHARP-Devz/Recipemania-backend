package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.UpdateUserDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserMapperImpl implements Mapper<UserEntity, UpdateUserDto> {
    private final ModelMapper modelMapper ;
    @Override
    public UpdateUserDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, UpdateUserDto.class);
    }

    @Override
    public UserEntity mapFrom(UpdateUserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
