package com.users.userservice.application.dto.request;

import com.users.userservice.domain.model.RoleModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SaveUserRequest(String firstName, String lastName, String identityNumber, String phoneNumber, LocalDate birthDate, String email, String password, @NotNull(message = "roleId no puede ser nulo") Long roleId) {
}
