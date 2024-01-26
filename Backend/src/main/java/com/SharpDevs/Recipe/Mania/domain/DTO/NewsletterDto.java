package com.example.newsletterupdates.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewsletterDto {

    private Long id;

    @NotBlank(message = "Email cannot be blank")
    @Email
    private String Email;

}
