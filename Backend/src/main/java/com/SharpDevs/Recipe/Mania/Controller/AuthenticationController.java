package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.AuthenticationService;
import com.SharpDevs.Recipe.Mania.domain.DTO.SignInRequest;
import com.SharpDevs.Recipe.Mania.domain.DTO.SignInResponse;
import com.SharpDevs.Recipe.Mania.domain.DTO.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path="/register")
    public ResponseEntity register(@RequestBody UserDto userDto){
       return  authenticationService.signUp(userDto);
    }
    @PostMapping(path="/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest){
        return  new ResponseEntity<>(authenticationService.signIn(signInRequest), HttpStatus.OK);
    }
}
