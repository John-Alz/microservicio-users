package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.RoleAlreadyExist;
import com.users.userservice.domain.model.RoleModel;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class RoleUseCaseTest {

    @Mock
    private RolePersistencePort rolePersistencePort;

    @Mock
    private RoleValidatorUseCase roleValidatorUseCase;

    @InjectMocks
    private RoleUseCase roleUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    RoleModel roleModel = new RoleModel(1L, "vendedor", "Descripcion vendedor");

    @Test
    void save() {
        doNothing().when(roleValidatorUseCase).validateName(roleModel.getName());
        doNothing().when(roleValidatorUseCase).validateDescription(roleModel.getDescription());
        doNothing().when(rolePersistencePort).save(roleModel);
        roleUseCase.save(roleModel);
        verify(rolePersistencePort, times(1)).save(roleModel);
    }

    @Test
    void save_RoleNotFound() {
        when(rolePersistencePort.findByName(roleModel.getName())).thenReturn(roleModel);

        assertThrows(RoleAlreadyExist.class, ()  -> {
            roleUseCase.save(roleModel);
        });

        verify(rolePersistencePort, never()).save(roleModel);
    }

}