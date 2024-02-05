package com.SharpDevs.Recipe.Mania.Repository;

<<<<<<< HEAD
import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
=======
>>>>>>> recipe-Dami
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {
<<<<<<< HEAD

    List<NewsletterEntity> findAll();

=======
    @Override
    Optional<NewsletterEntity> findById(Long id);

    List<NewsletterEntity> findAll();

    Optional<NewsletterEntity> findByEmail(String email);

>>>>>>> recipe-Dami
    Boolean existsByEmail(String email);

}
