package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

=======
>>>>>>> recipe-Dami
@Component
@RequiredArgsConstructor
public class NewsletterMapperImpl implements Mapper<NewsletterEntity, NewsletterDto> {

<<<<<<< HEAD
    private final ModelMapper modelMapper;
=======
    private final ModelMapper modelMapper ;
>>>>>>> recipe-Dami
    @Override
    public NewsletterDto mapTo(NewsletterEntity newsletter) {
        return modelMapper.map(newsletter, NewsletterDto.class);
    }

    @Override
    public NewsletterEntity mapFrom(NewsletterDto newsletterDto) {
        return modelMapper.map(newsletterDto, NewsletterEntity.class);
    }
<<<<<<< HEAD

    @Override
    public Iterable<NewsletterDto> mapListTo(Iterable<NewsletterEntity> newsletterEntityIterable) {
        return StreamSupport.stream(newsletterEntityIterable.spliterator(),false)
                .map(newsletterEntity ->
                        modelMapper.map(newsletterEntity, NewsletterDto.class)
                ).collect(Collectors.toList());
    }
=======
>>>>>>> recipe-Dami
}
