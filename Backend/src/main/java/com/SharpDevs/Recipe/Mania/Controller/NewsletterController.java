//package com.SharpDevs.Recipe.Mania.Controller;
//
//import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
//import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
//import com.example.newsletterupdates.Exception.EmailNotFoundException;
//import com.SharpDevs.Recipe.Mania.Repository.NewsletterRepository;
//import com.SharpDevs.Recipe.Mania.Service.NewsletterService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/newsletter")
//@CrossOrigin(origins = "*")
//public class NewsletterController {
//
//
//    private final NewsletterService newsletterService;
//    private final NewsletterRepository newsletterRepository;
//
//    @PostMapping
//    public ResponseEntity<NewsletterDto> saveEmail(@Validated @RequestBody NewsletterDto newsletterDto, BindingResult result){
//        if (result.hasErrors()){
//            ResponseEntity.badRequest().body("Input a Valid email or Email exists");
//        }
//        return newsletterService.saveEmail(newsletterDto);
//    }dfg
//
//    @GetMapping("/retrieve")
//    public Optional<NewsletterEntity> findAllEmails(String email){
//        return newsletterService.findAllEmails(email);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteEmail(@PathVariable long id){
//        System.out.println("---------------");
//        NewsletterDto email = newsletterRepository.findById(id)
//                .orElseThrow(() ->new EmailNotFoundException("Email does not exist with id:" + id));
//        newsletterRepository.delete(email);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
