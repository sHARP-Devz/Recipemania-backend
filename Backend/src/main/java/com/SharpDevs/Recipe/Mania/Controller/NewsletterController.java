package com.example.newsletterupdates.Controller;

import com.example.newsletterupdates.DTO.NewsletterDto;
import com.example.newsletterupdates.Entity.Newsletter;
import com.example.newsletterupdates.Exception.EmailNotFoundException;
import com.example.newsletterupdates.Repository.NewsletterRepository;
import com.example.newsletterupdates.Service.NewsletterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterController {

    @Autowired
    private final NewsletterService newsletterService;
    private final NewsletterRepository newsletterRepository;

    @PostMapping
    public ResponseEntity<Newsletter> saveEmail(@Valid @RequestBody NewsletterDto newsletterDto, BindingResult result){
        if (result.hasErrors()){
            ResponseEntity.badRequest().body("Input a Valid email or Email exists");
        }
        return newsletterService.saveEmail(newsletterDto);
    }

    @GetMapping("/retrieve")
    public Optional<Newsletter> findAllEmails(String email){
        return newsletterService.findAllEmails(email);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmail(@PathVariable long id){
        System.out.println("---------------");
        NewsletterDto email = newsletterRepository.findById(id)
                .orElseThrow(() ->new EmailNotFoundException("Email does not exist with id:" + id));
        newsletterRepository.delete(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
