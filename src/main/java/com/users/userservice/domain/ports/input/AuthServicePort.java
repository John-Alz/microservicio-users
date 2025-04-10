package com.users.userservice.domain.ports.input;

import com.users.userservice.domain.model.UserModel;

public interface AuthServicePort {

    UserModel login(String email, String password);

}
