package com.SharpDevs.Recipe.Mania.Repository;

import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {




    @Override
    Optional<NewsletterEntity> findById(Long id);

    List<NewsletterEntity> findAll();

    Optional<NewsletterEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

}
