package com.users.userservice.infrastructure.mappers;

import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.infrastructure.entities.RoleEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    RoleEntity modelToEntity(RoleModel roleModel);
    RoleModel entityToModel(RoleEntity roleEntity);

}
