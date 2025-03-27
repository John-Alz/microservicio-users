package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.EmptyException;
import com.users.userservice.domain.exceptions.MaxLengthDescriptionRole;
import com.users.userservice.domain.exceptions.MaxLengthNameRole;
import com.users.userservice.domain.utils.constants.DomainConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleValidatorUseCaseTest {

    private RoleValidatorUseCase roleValidatorUseCase;

    @BeforeEach
    void setUp() {
        roleValidatorUseCase = new RoleValidatorUseCase();
    }


    @Test
    void validateName() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> roleValidatorUseCase.validateName(""));
        assertEquals(DomainConstants.REQUIRED_NAME_ROLE, emptyException.getMessage());
    }

    @Test
    void valdateNameNotValid() {
        assertThrows(MaxLengthNameRole.class, () -> roleValidatorUseCase.validateName("vendedorencargadovendedorencargadovendedorencargadovendedorencargadovendedorencargadovendedorencargadovendedorencargado"));
    }

    @Test
    void validateDescription() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> roleValidatorUseCase.validateDescription(""));
        assertEquals(DomainConstants.REQUIRED_DESCRIPTION_ROLE, emptyException.getMessage());
    }

    @Test
    void valdateDescriptionNotValid() {
        assertThrows(MaxLengthDescriptionRole.class, () -> roleValidatorUseCase.validateDescription("vendedorencargadovendedorencargadovendedorencargadovendedorencargadovendedorencargadovendedorencargadovendedorencargado"));
    }

}