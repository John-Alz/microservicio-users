package com.users.userservice.application.services;

import com.users.userservice.application.dto.request.SaveRoleRequest;
import com.users.userservice.application.dto.response.SaveRoleResponse;

public interface IRoleService {

    SaveRoleResponse saveRole(SaveRoleRequest saveRoleRequest);

}
