package com.users.userservice.application.services.impl;

import com.users.userservice.application.dto.request.SaveUserRequest;
import com.users.userservice.application.dto.response.SaveUserResponse;
import com.users.userservice.application.mappers.UserDtoMapper;
import com.users.userservice.application.services.IUserService;
import com.users.userservice.domain.ports.input.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserServicePort userServicePort;
    private final UserDtoMapper userDtoMapper;

    @Override
    public SaveUserResponse saveUser(SaveUserRequest saveUserRequest) {
        userServicePort.save(userDtoMapper.requestToModel(saveUserRequest));
        return new SaveUserResponse("Usuario creado", LocalDateTime.now());
    }
}
