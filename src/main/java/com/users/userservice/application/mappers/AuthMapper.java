package com.users.userservice.application.mappers;

import com.users.userservice.application.dto.request.LoginUserRequest;
import com.users.userservice.domain.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    UserModel requestToModel(LoginUserRequest loginUserRequest);


}
