package com.SharpDevs.Recipe.Mania;

import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class Utils {

    public static UserEntity getUser (Long userId, UserRepository userRepository){

        return userRepository.findById(userId).orElse(null);
    }
}
