package com.users.userservice.infrastructure.endpoints.rest;

import com.users.userservice.application.dto.request.SaveUserRequest;
import com.users.userservice.application.dto.response.SaveUserResponse;
import com.users.userservice.application.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Operaciones relacionadas con la gestión de usuarios")
public class UserController {

    private final IUserService userService;

    @PostMapping
    @Operation(
            summary = "Crear un nuevo usuario",
            description = "Este endpoint permite la creación de un nuevo usuario en el sistema."
                    + "El usuario debe incluir información como nombre, apellido, documento de identidad, "
                    + "teléfono, fecha de nacimiento, correo electrónico, contraseña y el rol al que estará asociado.",
            tags = {"crear usuario"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos necesarios para crear un usuario",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SaveUserRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Usuario creado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SaveUserResponse.class)
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
    public ResponseEntity<SaveUserResponse> save(@RequestBody SaveUserRequest saveUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(saveUserRequest));
    }
}
