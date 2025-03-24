package com.users.userservice.domain.usecases;

import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.input.UserServicePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;
    private final UserValidatorUseCase userValidatorUseCase;

    public UserUseCase(UserPersistencePort userPersistencePort, UserValidatorUseCase userValidatorUseCase) {
        this.userPersistencePort = userPersistencePort;
        this.userValidatorUseCase = userValidatorUseCase;
    }

    @Override
    public void save(UserModel user) {

        userValidatorUseCase.validate(
                user.getFirstName(),
                user.getLastName(),
                user.getIdentityNumber(),
                user.getPhoneNumber(),
                user.getBirthDate(),
                user.getEmail(),
                user.getPassword()
        );

        userPersistencePort.save(user);
    }
}
