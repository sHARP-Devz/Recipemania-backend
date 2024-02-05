package com.SharpDevs.Recipe.Mania.Controller;

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
@RequestMapping("/api/v1/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterController {

    private final NewsletterService newsletterService;

    private final NewsletterRepository newsletterRepository;

    @PostMapping("/create")
    public ResponseEntity<NewsletterEntity> saveEmail(@Valid @RequestBody NewsletterDto newsletterDto, BindingResult result){
        if (result.hasErrors()){
            ResponseEntity.badRequest().body("Input a Valid email or Email exists");
        }
        return newsletterService.saveEmail(newsletterDto);
    }

    @GetMapping("/retrieve")
    public List<NewsletterEntity> findAllEmail(){
        return newsletterService.findAllEmails();
    }

//    @DeleteMapping("/deleteEmail")
//    public ResponseEntity<HttpStatus> deleteEmail(@PathVariable("email") @Valid @RequestBody String email) throws EmailNotFoundException{
//        System.out.println("---------------");
//            Optional<Newsletter> newsletter = newsletterRepository.findByEmail(email);
//        newsletterRepository.delete(newsletter);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
