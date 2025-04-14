package com.users.userservice.application.services.impl;

import com.users.userservice.application.dto.request.SaveRoleRequest;
import com.users.userservice.application.dto.response.SaveRoleResponse;
import com.users.userservice.application.mappers.RoleDtoMapper;
import com.users.userservice.application.services.IRoleService;
import com.users.userservice.application.utils.constants.ApplicationConstants;
import com.users.userservice.domain.ports.input.RoleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleServicePort roleServicePort;
    private final RoleDtoMapper roleDtoMapper;

    @Override
    public SaveRoleResponse saveRole(SaveRoleRequest saveRoleRequest) {
        roleServicePort.save(roleDtoMapper.requestToModel(saveRoleRequest));
        return new SaveRoleResponse(ApplicationConstants.ROLE_CREATE_MESSAGE, LocalDateTime.now());
    }
}
