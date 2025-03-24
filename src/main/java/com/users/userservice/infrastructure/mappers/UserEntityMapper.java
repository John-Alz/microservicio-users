package com.users.userservice.infrastructure.mappers;

import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.infrastructure.entities.RoleEntity;
import com.users.userservice.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.management.relation.Role;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    @Mapping(source = "role", target = "role", qualifiedByName = "roleIdToRoleEntity")
    UserEntity modelToEntity(UserModel userModel);


    @Named("roleIdToRoleEntity")
    default RoleEntity roleIdToRoleEntity(RoleModel roleModel) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(roleModel.getId());
        roleEntity.setName(roleModel.getName());
        roleEntity.setDescription(roleModel.getDescription());
        return roleEntity;
    }

    UserModel entityToModel(UserEntity userEntity);

}
