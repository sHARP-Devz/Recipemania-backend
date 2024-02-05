package com.SharpDevs.Recipe.Mania.Service;

import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsletterService {
    ResponseEntity<NewsletterEntity> saveEmail(NewsletterDto newsletterDto);

<<<<<<< HEAD
    ResponseEntity<Iterable<NewsletterDto>> getAllNewsletter();
=======
   List<NewsletterEntity> findAllEmails();
>>>>>>> recipe-Dami
}