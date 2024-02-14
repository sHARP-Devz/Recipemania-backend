package com.SharpDevs.Recipe.Mania;

import com.SharpDevs.Recipe.Mania.Repository.UserRepository;
import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class Utils {

    public static UserEntity getUser (Long userId, UserRepository userRepository) {
        try {
            UserEntity user = userRepository.findById(userId).orElse(null);
            return user;
        } catch (Exception E) {
            throw new RuntimeException(E);
        }
    }
}
