package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.RoleNoExistException;
import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.input.UserServicePort;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;
import com.users.userservice.domain.utils.constants.validate.UserValidatorUseCase;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;
    private final RolePersistencePort rolePersistencePort;
    private final UserValidatorUseCase userValidatorUseCase;

    public UserUseCase(UserPersistencePort userPersistencePort, RolePersistencePort rolePersistencePort, UserValidatorUseCase userValidatorUseCase) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.userValidatorUseCase = userValidatorUseCase;
    }

    @Override
    public void save(UserModel user) {

       RoleModel roleFound = rolePersistencePort.roleExists(user.getRole().getId());
       if (roleFound == null) {
           throw new RoleNoExistException();
       }

       userValidatorUseCase.validateEmptyFirstName(user.getFirstName());
       userValidatorUseCase.validateEmptyLastName(user.getLastName());
       userValidatorUseCase.validateIdentityNumber(user.getIdentityNumber());
       userValidatorUseCase.validatePhoneNumber(user.getPhoneNumber());
       userValidatorUseCase.validateEmptyBirthDate(user.getBirthDate());
       userValidatorUseCase.validateEmail(user.getEmail());
       userValidatorUseCase.validateEmptyPassword(user.getPassword());
       userValidatorUseCase.validateAge(user.getBirthDate());

       user.setPassword(userPersistencePort.passwordEncode(user.getPassword()));

        userPersistencePort.save(user);
    }
}
