package com.users.userservice.domain.usecases;

import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.ports.input.RoleServicePort;
import com.users.userservice.domain.ports.output.RolePersistencePort;

public class RoleUseCase implements RoleServicePort {

    private final RolePersistencePort rolePersistencePort;

    public RoleUseCase(RolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void save(RoleModel roleModel) {
        rolePersistencePort.save(roleModel);
    }
}
