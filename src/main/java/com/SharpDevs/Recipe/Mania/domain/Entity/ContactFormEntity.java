package com.SharpDevs.Recipe.Mania.domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(name = "email" , unique = true)
    @NotNull(message = "Email can't be null")
    @NotBlank(message = " email cannot be blank")
    private  String email;

    @Column(name = "phone")
    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    @Column(name = "message")
    @NotBlank(message = "Message cannot be blank")
    private String message;
}
