package com.users.userservice.domain.ports.input;

import com.users.userservice.domain.model.UserModel;

public interface UserServicePort {

    void save(UserModel user);


}
