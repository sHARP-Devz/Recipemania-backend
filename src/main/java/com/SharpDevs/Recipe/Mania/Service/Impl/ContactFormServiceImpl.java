package com.SharpDevs.Recipe.Mania.Service.Impl;

import com.SharpDevs.Recipe.Mania.Repository.ContactFormRepository;
import com.SharpDevs.Recipe.Mania.Service.ContactFormService;
import com.SharpDevs.Recipe.Mania.Service.EmailService;
import com.SharpDevs.Recipe.Mania.domain.Entity.ContactFormEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactFormServiceImpl implements ContactFormService {

    private final ContactFormRepository contactFormRepository;

    private final EmailService emailService;

    @Override
    public ContactFormEntity storeMessage(ContactFormEntity contactForm) {

        try {
            ContactFormEntity contactFormEntity = new ContactFormEntity();
            contactFormEntity.setName(contactForm.getName());
            contactFormEntity.setEmail(contactForm.getEmail());
            contactFormEntity.setPhone(contactForm.getPhone());
            contactFormEntity.setMessage(contactForm.getMessage());

            emailService.contactFormMail("tolex20004real@gmail.com", contactFormEntity.getName(), contactFormEntity.getEmail(), contactFormEntity.getPhone(), contactFormEntity.getMessage());
        } catch (RuntimeException e) {
            ContactFormEntity contactFormEntity = new ContactFormEntity();
            contactFormEntity.setName(contactForm.getName());
            contactFormEntity.setEmail(contactForm.getEmail());
            contactFormEntity.setPhone(contactForm.getPhone());
            contactFormEntity.setMessage(contactForm.getMessage());
            return contactFormRepository.save(contactFormEntity);
        }
        return contactForm;
    }
}
