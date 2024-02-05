package com.SharpDevs.Recipe.Mania.domain.Mappers.Impl;

import com.SharpDevs.Recipe.Mania.domain.DTO.NewsletterDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.NewsletterEntity;
import com.SharpDevs.Recipe.Mania.domain.Mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewsletterMapperImpl implements Mapper<NewsletterEntity, NewsletterDto> {

    private final ModelMapper modelMapper ;
    @Override
    public NewsletterDto mapTo(NewsletterEntity newsletter) {
        return modelMapper.map(newsletter, NewsletterDto.class);
    }

    @Override
    public NewsletterEntity mapFrom(NewsletterDto newsletterDto) {
        return modelMapper.map(newsletterDto, NewsletterEntity.class);
    }
}
