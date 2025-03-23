package com.users.userservice.domain.ports.output;

import com.users.userservice.domain.model.UserModel;

public interface UserPersistencePort {

    void save(UserModel user);

}
