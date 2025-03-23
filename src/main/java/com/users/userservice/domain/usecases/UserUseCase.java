package com.users.userservice.domain.usecases;

import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.input.UserServicePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void save(UserModel user) {
        userPersistencePort.save(user);
    }
}
