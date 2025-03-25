package com.users.userservice.domain.ports.output;

import com.users.userservice.domain.model.RoleModel;


public interface RolePersistencePort {

    void save(RoleModel roleModel);

    RoleModel roleExists(Long roleId);

    RoleModel findByName(String roleName);
}
