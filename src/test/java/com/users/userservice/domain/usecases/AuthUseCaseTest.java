package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.EmailInvalidException;
import com.users.userservice.domain.exceptions.PasswordInvalidException;
import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.output.UserPersistencePort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class AuthUseCaseTest {

    @Mock
    private UserPersistencePort userPersistencePort;

    @InjectMocks
    private AuthUseCase authUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThrowCredentialsInvalidExceptionWhenUserNotFound() {
        when(userPersistencePort.userExistWhitEmail("testemail@gmail.com")).thenReturn(null);

        assertThrows(EmailInvalidException.class, () -> {
            authUseCase.login("testemail@gmail.com", "12344");
        });

    }

    @Test
    void shouldThrowPasswordInvalidExceptionWhenPasswordDoesNotMatch() {
        RoleModel role = new RoleModel(1L, "admin", "descripcion admin");
        UserModel user = new UserModel(1L, "John", "Aangel", "100381232", "+573153723", LocalDate.of(2003, 07, 26), "john@gmail.com", "password1234", role);
        when(userPersistencePort.userExistWhitEmail("john@gmail.com")).thenReturn(user);
        when(userPersistencePort.passwordDecode("password1234", "password1234445")).thenReturn(false);

        assertThrows(PasswordInvalidException.class, () -> {
            authUseCase.login("john@gmail.com", "password1234");
        });
    }

    @Test
    void shouldReturnUserWhenCredentialsAreValid() {
        RoleModel role = new RoleModel(1L, "admin", "descripcion admin");
        UserModel user = new UserModel(1L, "John", "Aangel", "100381232", "+573153723", LocalDate.of(2003, 07, 26), "john@gmail.com", "password1234", role);
        when(userPersistencePort.userExistWhitEmail("john@gmail.com")).thenReturn(user);
        when(userPersistencePort.passwordDecode("password1234", "password1234")).thenReturn(true);

        UserModel result = authUseCase.login("john@gmail.com", "password1234");

        assertNotNull(result);
        assertEquals(result, user);
    }

}