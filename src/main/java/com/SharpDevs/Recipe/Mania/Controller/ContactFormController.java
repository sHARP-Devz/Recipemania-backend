package com.SharpDevs.Recipe.Mania.Controller;

import com.SharpDevs.Recipe.Mania.Service.ContactFormService;
import com.SharpDevs.Recipe.Mania.domain.Entity.ContactFormEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/contactform")
@CrossOrigin(origins = "*")
public class ContactFormController {

    private final ContactFormService contactFormService;

    @PostMapping("/user/send")
    public ResponseEntity<ContactFormEntity> addContactForm(@Valid @RequestBody ContactFormEntity contactForm, BindingResult result){
        if (result.hasErrors()){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        return ResponseEntity.ok(contactFormService.storeMessage(contactForm));
    }
}
