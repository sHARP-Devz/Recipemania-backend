package com.SharpDevs.Recipe.Mania.Controller;


import com.SharpDevs.Recipe.Mania.Exception.EmailNotFoundException;
import com.SharpDevs.Recipe.Mania.Repository.NewsletterRepository;
import com.SharpDevs.Recipe.Mania.Service.NewsletterService;
import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class NewsletterController {

    private final NewsletterService newsletterService;

    private final NewsletterRepository newsletterRepository;

    @PostMapping("newsletter/create")
    public ResponseEntity<NewsletterEntity> saveEmail(@Valid @RequestBody NewsletterDto newsletterDto, BindingResult result) {
        if (result.hasErrors()) {
            ResponseEntity.badRequest().body("Input a Valid email or Email exists");
        }
        return new ResponseEntity(newsletterService.saveEmail(newsletterDto).getStatusCode());
    }

    @GetMapping("/admin/newsletter/retrieve")
    public ResponseEntity<Iterable<NewsletterDto>> getAllNewsletterEmails() {
        return newsletterService.getAllNewsletter();
    }

    @DeleteMapping("/admin/newsletter//{id}")
    public ResponseEntity<HttpStatus> deleteEmail(@PathVariable Long id,@Valid @RequestBody NewsletterDto newsletterDto) throws EmailNotFoundException {
        if (newsletterRepository.existsByEmail(newsletterDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("---------------");
        NewsletterEntity newsletter = newsletterRepository.findById(id)
                .orElseThrow(() -> new EmailNotFoundException("Email not Found"));
        newsletterRepository.delete(newsletter);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }   
}

