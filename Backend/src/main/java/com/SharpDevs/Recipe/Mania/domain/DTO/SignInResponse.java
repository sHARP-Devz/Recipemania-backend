package com.SharpDevs.Recipe.Mania.domain.DTO;

import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {
    private UserEntity userEntity;
    private  String  token;
}
