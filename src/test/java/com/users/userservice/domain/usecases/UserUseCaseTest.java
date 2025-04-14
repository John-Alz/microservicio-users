package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.EmailInvalidException;
import com.users.userservice.domain.exceptions.RoleNoExistException;
import com.users.userservice.domain.exceptions.UserWithEmailExistException;
import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;
import com.users.userservice.domain.utils.constants.validate.UserValidatorUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UserUseCaseTest {

    @Mock
    private UserPersistencePort userPersistencePort;

    @Mock
    private RolePersistencePort rolePersistencePort;

    @Mock
    private UserValidatorUseCase userValidatorUseCase;


    @InjectMocks
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        clearInvocations(userPersistencePort, userValidatorUseCase);
    }

    RoleModel roleModel = new RoleModel(1L, "vendedor", "Descripcion vendedor");
    UserModel newUser = new UserModel(34L, "John", "Angel", "100370734", "+5732463784", LocalDate.of(2003, 07, 26), "john@gmail.com", "1234", roleModel);

    @Test
    void save_RoleFound() {
        when(rolePersistencePort.roleExists(newUser.getRole().getId())).thenReturn(roleModel);


//        doNothing().when(userValidatorUseCase).validateEmptyFirstName(newUser.getFirstName());
//        doNothing().when(userValidatorUseCase).validateEmptyLastName(newUser.getLastName());
//        doNothing().when(userValidatorUseCase).validateIdentityNumber(newUser.getIdentityNumber());
//        doNothing().when(userValidatorUseCase).validatePhoneNumber(newUser.getPhoneNumber());
//        doNothing().when(userValidatorUseCase).validateEmptyBirthDate(newUser.getBirthDate());
//        doNothing().when(userValidatorUseCase).validateEmail(newUser.getEmail());
//        doNothing().when(userValidatorUseCase).validateEmptyPassword(newUser.getPassword());


        doNothing().when(userPersistencePort).save(newUser);
        userUseCase.save(newUser);

        verify(rolePersistencePort, times(1)).roleExists(newUser.getRole().getId());
        verify(userPersistencePort, times(1)).save(newUser);
    }

    @Test
    void save_RoleNotFound() {
        when(rolePersistencePort.roleExists(newUser.getRole().getId())).thenReturn(null);

        assertThrows(RoleNoExistException.class, () -> {
            userUseCase.save(newUser);
        });

        verify(rolePersistencePort, times(1)).roleExists(newUser.getRole().getId());

        verify(userPersistencePort, never()).save(newUser);

    }

    @Test
    void save_EmailNotFound() {
        when(rolePersistencePort.roleExists(newUser.getRole().getId())).thenReturn(roleModel);
        when(userPersistencePort.userExistWhitEmail(newUser.getEmail())).thenReturn(newUser);

        assertThrows(UserWithEmailExistException.class, () -> {
            userUseCase.save(newUser);
        });

        verify(userPersistencePort, times(1)).userExistWhitEmail(newUser.getEmail());

        verify(userPersistencePort, never()).save(newUser);

    }

}