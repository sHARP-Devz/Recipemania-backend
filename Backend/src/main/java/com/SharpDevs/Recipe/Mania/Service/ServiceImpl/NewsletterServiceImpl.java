//package com.SharpDevs.Recipe.Mania.Service.ServiceImpl;
//
//import com.SharpDevs.Recipe.Mania.Service.NewsletterService;
//import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
//import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
//import com.SharpDevs.Recipe.Mania.Repository.NewsletterRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class NewsletterServiceImpl implements NewsletterService {
//
//    private final NewsletterRepository newsletterRepository;
//
//
//    @Override
//    public ResponseEntity<NewsletterDto> saveEmail(NewsletterDto newsletterDto) {
//        NewsletterDto newsletter = new NewsletterDto();
//
//        newsletter.setEmail(newsletter.getEmail());
//        return ResponseEntity.ok(newsletterRepository.save(newsletter));
//    }
//
//    public Optional<NewsletterEntity> findAllEmails(String email){
//        return newsletterRepository.findAllEmails(email);
//    }
//}
