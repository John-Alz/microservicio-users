package com.users.userservice.domain.ports.output;

import com.users.userservice.domain.model.UserModel;

public interface AuthPersistencePort {

    UserModel userExist(String email);


}
