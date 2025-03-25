package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.*;
import com.users.userservice.domain.utils.constants.DomainConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorUseCaseTest {

    private UserValidatorUseCase userValidatorUseCase;


    @BeforeEach
    void setUp() {
        userValidatorUseCase = new UserValidatorUseCase();
    }

//    @Test
//    void ShouldNotThrowException_whenUserDataIsValid() {
//        assertDoesNotThrow(() -> userValidatorUseCase.validate(
//                "John", "Angel", "100370734", "+5732463784", LocalDate.of(2003, 07, 26), "john@gmail.com", "1234"
//        ));
//    }

    @Test
    void ShouldThrowEmptyException_whenFisrtNameIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validateEmptyFirstName(""));
        assertEquals(DomainConstants.REQUIRED_FIRST_NAME, emptyException.getMessage());
    }

    @Test
    void ShouldThrowEmptyException_whenLastNameIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validateEmptyLastName(""));
        assertEquals(DomainConstants.REQUIRED_LAST_NAME, emptyException.getMessage());
    }

    @Test
    void ShouldThrowEmptyException_whenIdentityNumberIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validateIdentityNumber(""));
        assertEquals(DomainConstants.REQUIRED_IDENTITY_NUMBER, emptyException.getMessage());
    }

    @Test
    void ShouldThrowEmptyException_whenIdentityNumberIsInvalid() {
        assertThrows(IdentityNumberException.class, () -> userValidatorUseCase.validateIdentityNumber("invalid"));

    }

    @Test
    void ShouldThrowEmptyException_whenPhoneNumberIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validatePhoneNumber(""));
        assertEquals(DomainConstants.REQUIRED_PHONE_NUMBER, emptyException.getMessage());
    }

    @Test
    void ShouldThrowEmptyException_whenPhoneNumberIsInvalid() {
        assertThrows(PhoneNumberException.class, () -> userValidatorUseCase.validatePhoneNumber("+57314405732324343"));
    }


    @Test
    void ShouldThrowEmptyException_whenBirthDateIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validateEmptyBirthDate(null));
        assertEquals(DomainConstants.REQUIRED_BIRTH_DATE, emptyException.getMessage());
    }

    @Test
    void ShouldThrowEmptyException_whenEmailIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validateEmail(""));
        assertEquals(DomainConstants.REQUIRED_EMAIL, emptyException.getMessage());
    }

    @Test
    void ShouldThrowEmptyException_whenEmailIsInvalid() {
        assertThrows(EmailException.class, () -> userValidatorUseCase.validateEmail("john@.com"));
    }

    @Test
    void ShouldThrowEmptyException_whenPasswordIsEmpty() {
        EmptyException emptyException = assertThrows(EmptyException.class, () -> userValidatorUseCase.validateEmptyPassword(""));
        assertEquals(DomainConstants.REQUIRED_PASSWORD, emptyException.getMessage());
    }

    @Test
    void ShouldThrowAgeException_whenAgeIsInvalid() {
        assertThrows(AgeInvalidException.class, () -> userValidatorUseCase.validateAge( LocalDate.of(2010, 07, 26)));
    }




}