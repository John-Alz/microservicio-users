package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.EmailInvalidException;
import com.users.userservice.domain.exceptions.PasswordInvalidException;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.input.AuthServicePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;

public class AuthUseCase implements AuthServicePort {

    private final UserPersistencePort userPersistencePort;

    public AuthUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserModel login(String email, String password) {

        UserModel userFound = userPersistencePort.userExistWhitEmail(email);

        if (userFound == null) {
            throw new EmailInvalidException();
        }

        if (!userPersistencePort.passwordDecode(password, userFound.getPassword())) {
            throw new PasswordInvalidException();
        }
        return userFound;

    }
}
