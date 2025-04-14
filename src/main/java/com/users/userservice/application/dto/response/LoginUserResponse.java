package com.users.userservice.application.dto.response;

public record LoginUserResponse(String email, String message, String token) {
}
