package com.users.userservice.domain.utils.constants.validate;

import com.users.userservice.domain.exceptions.*;
import com.users.userservice.domain.utils.constants.DomainConstants;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class UserValidatorUseCase {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(DomainConstants.REGEX_EMAIL);

    private static  final Pattern PHONE_PATTERN = Pattern.compile(DomainConstants.REGEX_PHONE_NUMBER);
    private static final Pattern DOCUMENT_PATTERN = Pattern.compile(DomainConstants.REGEX_IDENTITY_NUMBER);


    public void validateEmptyFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_FIRST_NAME);
        }
    }

    public void validateEmptyLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_LAST_NAME);
        }
    }

    public void validateIdentityNumber(String identityNumber) {
        if (identityNumber == null || identityNumber.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_IDENTITY_NUMBER);
        }
        if(!DOCUMENT_PATTERN.matcher(identityNumber).matches()) {
            throw new IdentityNumberException();
        }
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_PHONE_NUMBER);
        }
        if (!PHONE_PATTERN.matcher(phoneNumber).matches()) {
            throw new PhoneNumberException();
        }
    }

    public void validateEmptyBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new EmptyException(DomainConstants.REQUIRED_BIRTH_DATE);
        }
    }

    public void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_EMAIL);
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new EmailException();
        }
    }

    public void validateEmptyPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_PASSWORD);
        }
    }

    public void validateAge(LocalDate birthDate) {
        if(Period.between(birthDate, LocalDate.now()).getYears() < DomainConstants.MIN_AGE) {
            throw new AgeInvalidException();
        }
    }

}
