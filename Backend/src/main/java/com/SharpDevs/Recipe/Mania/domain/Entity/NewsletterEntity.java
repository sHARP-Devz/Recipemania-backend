package com.SharpDevs.Recipe.Mania.domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
<<<<<<< HEAD
@Table(name = "newsletter")
=======
@Table(name = "db_newsletter")
>>>>>>> recipe-Dami
public class NewsletterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email" , unique = true)
    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "UserEntity")
    private UserEntity userEntity;
}
