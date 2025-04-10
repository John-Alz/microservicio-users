package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.CredentialsInvalidException;
import com.users.userservice.domain.exceptions.PasswordInvalidException;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.input.AuthServicePort;
import com.users.userservice.domain.ports.output.AuthPersistencePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;

public class AuthUseCase implements AuthServicePort {

    private final AuthPersistencePort authPersistencePort;
    private final UserPersistencePort userPersistencePort;

    public AuthUseCase(AuthPersistencePort authPersistencePort, UserPersistencePort userPersistencePort) {
        this.authPersistencePort = authPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserModel login(String email, String password) {

        UserModel userFound = authPersistencePort.userExist(email);
        System.out.println(userFound.getRole().getName());

        if (userFound == null) {
            throw new CredentialsInvalidException();
        }

        if (!userPersistencePort.passwordDecode(password, userFound.getPassword())) {
            throw new PasswordInvalidException();
        }
        return userFound;

    }
}
