package com.example.newsletterupdates.Service;

import com.example.newsletterupdates.DTO.NewsletterDto;
import com.example.newsletterupdates.Entity.Newsletter;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface NewsletterService {
    ResponseEntity<Newsletter> saveEmail(NewsletterDto newsletterDto);

    Optional<Newsletter> findAllEmails(String email);
}