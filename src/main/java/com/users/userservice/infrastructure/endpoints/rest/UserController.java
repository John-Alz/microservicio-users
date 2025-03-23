package com.users.userservice.infrastructure.endpoints.rest;

import com.users.userservice.application.dto.request.SaveUserRequest;
import com.users.userservice.application.dto.response.SaveUserResponse;
import com.users.userservice.application.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    private ResponseEntity<SaveUserResponse> save(@RequestBody SaveUserRequest saveUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(saveUserRequest));
    }
}
