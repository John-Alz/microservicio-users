package com.users.userservice.domain.ports.output;

import com.users.userservice.domain.model.RoleModel;

import java.util.Optional;

public interface RolePersistencePort {

    void save(RoleModel roleModel);

}
