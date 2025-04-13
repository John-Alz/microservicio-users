package com.users.userservice.domain.ports.output;

import com.users.userservice.domain.model.UserModel;

public interface UserPersistencePort {

    void save(UserModel user);
    String passwordEncode(String password);

    boolean passwordDecode(String passwordRequest, String passwordUserDb);

    UserModel userExistWhitEmail(String email);
}
