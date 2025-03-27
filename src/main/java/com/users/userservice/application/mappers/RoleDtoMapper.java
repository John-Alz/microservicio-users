package com.users.userservice.application.mappers;

import com.users.userservice.application.dto.request.SaveRoleRequest;
import com.users.userservice.domain.model.RoleModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleDtoMapper {

    RoleModel requestToModel(SaveRoleRequest saveRoleRequest);

}
