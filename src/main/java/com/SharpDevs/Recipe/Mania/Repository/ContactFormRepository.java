package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.Entity.ContactFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactFormRepository extends JpaRepository<ContactFormEntity, Long> {

    Boolean existsByEmail(String email);
}
