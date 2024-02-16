package com.SharpDevs.Recipe.Mania;

import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Utils {
    private final UserRepository userRepository;
    public  UserEntity getUser (Long userId) {

           Optional<UserEntity> userEntity  = userRepository.findById(userId);
           if(userEntity.isPresent()) return userEntity.get();
            else return null;

    }
}
