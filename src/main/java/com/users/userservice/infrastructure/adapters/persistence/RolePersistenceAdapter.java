package com.users.userservice.infrastructure.adapters.persistence;

import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.infrastructure.mappers.RoleEntityMapper;
import com.users.userservice.infrastructure.repositories.mysql.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public void save(RoleModel roleModel) {
        roleRepository.save(roleEntityMapper.modelToEntity(roleModel));
    }

    @Override
    public RoleModel roleExists(Long roleId) {
        return roleEntityMapper.entityToModel(roleRepository.findById(roleId).orElse(null));
    }


}
