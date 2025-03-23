package com.users.userservice.domain.ports.input;

import com.users.userservice.domain.model.User;

public interface UserServicePort {

    void save(User user);


}
