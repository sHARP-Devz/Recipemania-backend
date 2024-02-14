package com.SharpDevs.Recipe.Mania.Service.ServiceImpl;

import com.SharpDevs.Recipe.Mania.Repository.ContactFormRepository;
import com.SharpDevs.Recipe.Mania.Service.ContactFormService;
import com.SharpDevs.Recipe.Mania.Service.EmailService;
import com.SharpDevs.Recipe.Mania.domain.Entity.ContactFormEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactFormServiceImpl implements ContactFormService {

    private ContactFormRepository contactFormRepository;

    private final EmailService emailService;

    @Override
    public ContactFormEntity storeMessage(ContactFormEntity contactForm) {

        ContactFormEntity contactFormEntity = new ContactFormEntity();
        contactFormEntity.setName(contactForm.getName());
        contactFormEntity.setEmail(contactForm.getEmail());
        contactFormEntity.setMessage(contactForm.getMessage());


        emailService.contactFormMail("tolex20004real@gmail",contactFormEntity.getName(),contactFormEntity.getEmail(), contactFormEntity.getPhone(),contactFormEntity.getMessage());
        return  contactFormRepository.save(contactFormEntity);
    }
}
