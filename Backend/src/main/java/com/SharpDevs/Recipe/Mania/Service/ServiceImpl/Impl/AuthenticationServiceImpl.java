package com.SharpDevs.Recipe.Mania.Service.ServiceImpl.Impl;

import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.Service.AuthenticationService;
import com.SharpDevs.Recipe.Mania.Service.JWTService;
import com.SharpDevs.Recipe.Mania.domain.DTO.*;
import com.SharpDevs.Recipe.Mania.domain.Entity.Role;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private  final Mapper<UserEntity, SignUpDto> signUpMapper;
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final  JWTService jwtService;


    @Override
    public ResponseEntity signUp(SignUpDto signUpDto) {
        try {
            signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
            UserEntity userEntity = signUpMapper.mapFrom(signUpDto);
            userEntity.setRole(Role.USER);
            System.out.println(userEntity);
            userRepository.save(userEntity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception error) {
            System.out.println(error);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("User doest not exist"));

        var jwt = jwtService.generateToken(user);

        return new SignInResponse(user, jwt);
    }

    @Override
    public UserEntity findById(Long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public String checkMail(String email) {
        return userRepository.findByEmail(email).map(
                existingUser -> {
                    String foundEmail = Optional.ofNullable(existingUser.getEmail()).orElse(null);
                    return foundEmail;
                }).orElseThrow(
                () -> new RuntimeException("Email Not Found")
        );
    }}


