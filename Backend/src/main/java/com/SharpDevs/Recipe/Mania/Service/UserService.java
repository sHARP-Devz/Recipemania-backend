package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.ChangePasswordRequest;
import com.SharpDevs.Recipe.Mania.domain.DTO.UpdateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService {
    UserDetailsService userDetailsService();

   ResponseEntity<UpdateUserDto>  updateUser(UpdateUserDto userDto, Long id);

   ResponseEntity changePassword(ChangePasswordRequest newPassword, Long id);
}

