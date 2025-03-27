package com.users.userservice.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String identityNumber;
    String phoneNumber;
    LocalDate birthDate;
    String email;
    String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    RoleEntity role;
}
