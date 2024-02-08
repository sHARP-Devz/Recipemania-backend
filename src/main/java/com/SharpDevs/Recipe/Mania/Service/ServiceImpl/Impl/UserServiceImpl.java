package com.SharpDevs.Recipe.Mania.Service.ServiceImpl.Impl;

import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.Service.UserService;
import com.SharpDevs.Recipe.Mania.domain.DTO.ChangePasswordRequest;
import com.SharpDevs.Recipe.Mania.domain.DTO.UserDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final Mapper<UserEntity, UserDto> userMapper;

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto, Long id) {

        if (userRepository.existsById(id)) {
            return userRepository.findById(id).map(
                    existingUser -> {

                        Optional.ofNullable(userDto.getFirstName()).ifPresent(existingUser::setFirstName);
                        Optional.ofNullable(userDto.getLastName()).ifPresent(existingUser::setLastName);
                        Optional.ofNullable(userDto.getDescription()).ifPresent(existingUser::setDescription);
                        Optional.ofNullable(userDto.getCountry()).ifPresent(existingUser::setCountry);

                        System.out.println(existingUser);

                        UserDto savedUserDto = userMapper.mapTo(userRepository.save(existingUser));

                        return new ResponseEntity<>(savedUserDto, HttpStatus.OK);
                    }
            ).orElseThrow(() -> new RuntimeException("User Did Not Update"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity changePassword(ChangePasswordRequest changePasswordRequest, Long id) {
        try {
            return userRepository.findById(id).map(
                    existingUser -> {

                        existingUser.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
                        userRepository.save(existingUser);
                        return new ResponseEntity<>(HttpStatus.OK);
                    }
            ).orElseThrow(() -> new RuntimeException("User Not Found"));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }







