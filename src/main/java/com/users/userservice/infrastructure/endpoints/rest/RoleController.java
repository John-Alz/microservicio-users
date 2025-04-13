package com.users.userservice.infrastructure.endpoints.rest;

import com.users.userservice.application.dto.request.SaveRoleRequest;
import com.users.userservice.application.dto.response.SaveRoleResponse;
import com.users.userservice.application.services.IRoleService;
import com.users.userservice.infrastructure.utils.constants.InfrastructureConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = InfrastructureConstants.TAG_ROLES_CONTROLLER, description = InfrastructureConstants.DESC_ROLES_CONTROLLER)
public class RoleController {

    private final IRoleService roleService;

    @PostMapping
    @Operation(
            summary = "Crear un nuevo role.",
            description = "Este endpoint permite la creación de un nuevo role en el sistema." +
                    "El role debe incluir informacion como nombre y descripcion.",
            tags = {"Crear role"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos necesarios para crear un role.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = SaveRoleRequest.class
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Role Creado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SaveRoleResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Solicitud incorrecta. Verifique los datos enviados.",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<SaveRoleResponse> save(@Valid @RequestBody SaveRoleRequest saveRoleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.saveRole(saveRoleRequest));
    }

}
