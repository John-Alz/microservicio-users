package com.users.userservice.domain.ports.output;

import com.users.userservice.domain.model.User;

public interface UserPersistencePort {

    void save(User user);

}
