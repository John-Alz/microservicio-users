package com.users.userservice.application.dto.request;

import com.users.userservice.domain.model.RoleModel;

import java.time.LocalDate;

public record SaveUserRequest(String firstName, String lastName, String identityNumber, String phoneNumber, LocalDate birthDate, String email, String password, Long roleId) {
}
