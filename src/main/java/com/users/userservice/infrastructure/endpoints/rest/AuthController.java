package com.users.userservice.infrastructure.endpoints.rest;

import com.users.userservice.application.dto.request.LoginUserRequest;
import com.users.userservice.application.dto.response.LoginUserResponse;
import com.users.userservice.application.services.IAuthService;
import com.users.userservice.infrastructure.utils.constants.InfrastructureConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = InfrastructureConstants.TAG_AUTH_CONTROLLER, description = InfrastructureConstants.DESC_AUTH_CONTROLLER)
public class AuthController {

    private final IAuthService authService;

    @PostMapping
    @Operation(
            summary = "Loguearse en el sistema",
            description = "Este endpoint permite loguearse como usuario en el sistema."
                    + "El usuario debe loguearse con email y contraseña.",
            tags = {"login"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos necesarios para loguearse.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginUserRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Usuario logueado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = LoginUserResponse.class)
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
    public ResponseEntity<LoginUserResponse> login(@RequestBody  LoginUserRequest loginUserRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginUser(loginUserRequest));
    }

}
