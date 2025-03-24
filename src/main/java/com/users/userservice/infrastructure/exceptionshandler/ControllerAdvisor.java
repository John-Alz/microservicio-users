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

}
