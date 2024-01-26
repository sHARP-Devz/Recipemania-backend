package com.SharpDevs.Recipe.Mania.domain.DTO;

import com.SharpDevs.Recipe.Mania.domain.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {
    private  User user;
    private  String  token;
}
