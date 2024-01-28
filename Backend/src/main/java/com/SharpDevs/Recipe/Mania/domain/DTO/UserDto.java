package com.SharpDevs.Recipe.Mania.domain.DTO;

import com.SharpDevs.Recipe.Mania.domain.Entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NonNull;

public class    UserDto {

    private String firstName;

    private String lastName;

    private  String email;

    private String password;

    private String country;

    private String  description;

    private Role role;
}
