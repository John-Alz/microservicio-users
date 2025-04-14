package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.RoleAlreadyExist;
import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.ports.input.RoleServicePort;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.domain.utils.constants.validate.RoleValidatorUseCase;

public class RoleUseCase implements RoleServicePort {

    private final RolePersistencePort rolePersistencePort;
    private final RoleValidatorUseCase roleValidatorUseCase;

    public RoleUseCase(RolePersistencePort rolePersistencePort, RoleValidatorUseCase roleValidatorUseCase) {
        this.rolePersistencePort = rolePersistencePort;
        this.roleValidatorUseCase = roleValidatorUseCase;
    }

    @Override
    public void save(RoleModel roleModel) {
        RoleModel roleFound = rolePersistencePort.findByName(roleModel.getName());
        if (roleFound != null) {
            throw new RoleAlreadyExist();
        }

        roleValidatorUseCase.validateName(roleModel.getName());
        roleValidatorUseCase.validateDescription(roleModel.getDescription());

        rolePersistencePort.save(roleModel);
    }
}
