package com.example.newsletterupdates.Service.ServiceImpl;

import com.example.newsletterupdates.DTO.NewsletterDto;
import com.example.newsletterupdates.Entity.Newsletter;
import com.example.newsletterupdates.Repository.NewsletterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsletterServiceImpl {

    private final NewsletterRepository newsletterRepository;

    public ResponseEntity<NewsletterDto> saveEmail(){
        NewsletterDto newsletter = new NewsletterDto();

        newsletter.setEmail(newsletter.getEmail());
        return ResponseEntity.ok(newsletterRepository.save(newsletter));
    }

    public Optional<Newsletter> findAllEmails(String email){
        return newsletterRepository.findAllEmails(email);
    }
}
