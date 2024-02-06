package com.SharpDevs.Recipe.Mania.Service.ServiceImpl;

import com.SharpDevs.Recipe.Mania.Repository.NewsletterRepository;
import com.SharpDevs.Recipe.Mania.Service.NewsletterService;
import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsletterServiceImpl implements NewsletterService {

    private  final Mapper<NewsletterEntity, NewsletterDto> newsletterMapper;
    private final NewsletterRepository newsletterRepository;

    public ResponseEntity<NewsletterEntity> saveEmail(NewsletterDto newsletterDto){
        if (newsletterRepository.existsByEmail(newsletterDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        NewsletterEntity newsletter = newsletterMapper.mapFrom(newsletterDto);
        newsletter.setEmail(newsletterDto.getEmail());
        return ResponseEntity.ok(newsletterRepository.save(newsletter));
    }

    @Override
    public ResponseEntity<Iterable<NewsletterDto>> getAllNewsletter() {
        try{
            Iterable<NewsletterEntity> allNewsletterEmailsList = newsletterRepository.findAll();
            return new ResponseEntity<>(newsletterMapper.mapListTo(allNewsletterEmailsList),HttpStatus.OK);
        }catch (Exception err) {
            throw new RuntimeException("Failed to fetch Newsletter emails");
        }
    }
    public List<NewsletterEntity> findAllEmails(){
        return newsletterRepository.findAll();
    }

}
