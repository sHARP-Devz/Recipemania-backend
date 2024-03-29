package com.SharpDevs.Recipe.Mania.Repository;


import com.SharpDevs.Recipe.Mania.domain.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);

    Boolean existsByUserName(String userName);
    Optional<UserEntity> findByUserName(String userName);
}
