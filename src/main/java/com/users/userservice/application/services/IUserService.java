package com.users.userservice.application.services;

import com.users.userservice.application.dto.request.SaveUserRequest;
import com.users.userservice.application.dto.response.SaveUserResponse;

public interface IUserService {

    SaveUserResponse saveUser(SaveUserRequest saveUserRequest);

}
