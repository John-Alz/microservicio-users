package com.users.userservice.application.services;

import com.users.userservice.application.dto.request.LoginUserRequest;
import com.users.userservice.application.dto.response.LoginUserResponse;

public interface IAuthService {

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);


}
