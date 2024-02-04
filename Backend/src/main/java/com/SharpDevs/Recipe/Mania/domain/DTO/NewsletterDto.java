package com.SharpDevs.Recipe.Mania.domain.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NewsletterDto {

    private Long id;

    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;

}
