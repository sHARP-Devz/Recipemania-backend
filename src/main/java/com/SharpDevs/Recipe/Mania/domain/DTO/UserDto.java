package com.SharpDevs.Recipe.Mania.domain.DTO;

import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import com.SharpDevs.Recipe.Mania.domain.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String country;

    private String  description;

    private Role role;
}
