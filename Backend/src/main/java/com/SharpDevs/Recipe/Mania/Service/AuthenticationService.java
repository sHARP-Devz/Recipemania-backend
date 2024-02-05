package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.SignInResponse;
import com.SharpDevs.Recipe.Mania.domain.DTO.SignInRequest;
import com.SharpDevs.Recipe.Mania.domain.DTO.SignUpDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

ResponseEntity signUp(SignUpDto signUpDto);
SignInResponse signIn(SignInRequest signInRequest);

    Object findById(Long id);

    String checkMail(String email);


}
