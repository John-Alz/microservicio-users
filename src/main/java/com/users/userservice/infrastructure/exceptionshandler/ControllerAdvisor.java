package com.users.userservice.infrastructure.exceptionshandler;

import com.users.userservice.domain.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(IdentityNumberException.class)
    public ResponseEntity<ExceptionResponse> handleIdentityNumberException(IdentityNumberException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("El documento de identidad debe ser numérico.", LocalDateTime.now()));
    }

    @ExceptionHandler(PhoneNumberException.class)
    public ResponseEntity<ExceptionResponse> handlePhoneNumberException(PhoneNumberException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("El numero de telefono no es valido.", LocalDateTime.now()));
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ExceptionResponse> handleEmailException(EmailException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("El email no es valido.", LocalDateTime.now()));
    }

    @ExceptionHandler(AgeInvalidException.class)
    public ResponseEntity<ExceptionResponse> handleAgeInvalidException(AgeInvalidException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("No eres mayor de edad.", LocalDateTime.now()));
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyException(EmptyException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(RoleNoExistException.class)
    public ResponseEntity<ExceptionResponse> handleRoleNoExistException(RoleNoExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("El Rol no existe", LocalDateTime.now()));
    }

    @ExceptionHandler(RoleAlreadyExist.class)
    public ResponseEntity<ExceptionResponse> handleRoleAlreadyExist(RoleAlreadyExist exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("El Rol existe", LocalDateTime.now()));
    }

    @ExceptionHandler(MaxLengthNameRole.class)
    public ResponseEntity<ExceptionResponse> handleMaxLengthNameRole(MaxLengthNameRole exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("El nombre del rol debe ser menor a 20 caracteres", LocalDateTime.now()));
    }

    @ExceptionHandler(MaxLengthDescriptionRole.class)
    public ResponseEntity<ExceptionResponse> handleMaxLengthDescriptionRole(MaxLengthDescriptionRole exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("La descripcion del rol debe ser menor a 50 caracteres", LocalDateTime.now()));
    }

    @ExceptionHandler(UserWithEmailExistException.class)
    public ResponseEntity<ExceptionResponse> handleUserWithEmailExistException(UserWithEmailExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("Este correo ya esta asociado a otro usuario.", LocalDateTime.now()));
    }

    @ExceptionHandler(CredentialsInvalidException.class)
    public ResponseEntity<ExceptionResponse> handleCredentialsInvalidException(CredentialsInvalidException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("Este email no corresponde a ningun usuairo.", LocalDateTime.now()));
    }

    @ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity<ExceptionResponse> handlePasswordInvalidException(PasswordInvalidException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse("Contrasena inválidaa", LocalDateTime.now()));
    }

}
