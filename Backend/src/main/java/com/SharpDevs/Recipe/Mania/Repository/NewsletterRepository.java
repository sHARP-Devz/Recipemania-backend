package com.example.newsletterupdates.Repository;

import com.example.newsletterupdates.DTO.NewsletterDto;
import com.example.newsletterupdates.Entity.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsletterRepository extends JpaRepository<NewsletterDto, Long> {
    @Override
    Optional<NewsletterDto> findById(Long id);

    Optional<Newsletter> findAllEmails(String email);
}
