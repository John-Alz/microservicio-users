package com.users.userservice.infrastructure.endpoints.rest;

import com.users.userservice.application.dto.request.SaveRoleRequest;
import com.users.userservice.application.dto.response.SaveRoleResponse;
import com.users.userservice.application.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping
    private ResponseEntity<SaveRoleResponse> save(@RequestBody SaveRoleRequest saveRoleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.saveRole(saveRoleRequest));
    }

}
