package com.users.userservice.application.mappers;


import com.users.userservice.application.dto.request.SaveUserRequest;
import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {

    @Mapping(source = "roleId", target = "role")
    UserModel requestToModel(SaveUserRequest saveUserRequest);

    default RoleModel mapRoleIdToRole(Long roleId) {
        if (roleId == null) {
            return null;
        }
        RoleModel role = new RoleModel();
        role.setId(roleId);
        return role;
    }
}
