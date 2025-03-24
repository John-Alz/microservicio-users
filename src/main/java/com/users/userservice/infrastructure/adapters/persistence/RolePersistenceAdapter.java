package com.users.userservice.infrastructure.adapters.persistence;

import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.infrastructure.mappers.RoleEntityMapper;
import com.users.userservice.infrastructure.repositories.mysql.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public void save(RoleModel roleModel) {
        System.out.println("Guardando rol: " + roleModel);
        roleRepository.save(roleEntityMapper.modelToEntity(roleModel));
    }


}
