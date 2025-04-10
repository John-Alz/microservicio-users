package com.users.userservice.infrastructure.endpoints.rest;

import com.users.userservice.application.dto.request.LoginUserRequest;
import com.users.userservice.application.dto.response.LoginUserResponse;
import com.users.userservice.application.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping
    public ResponseEntity<LoginUserResponse> login(@RequestBody  LoginUserRequest loginUserRequest) {
        System.out.println("Email controller: " + loginUserRequest.email());

        return ResponseEntity.status(HttpStatus.OK).body(authService.loginUser(loginUserRequest));
    }

}
