package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.*;
import com.users.userservice.domain.utils.constants.DomainConstants;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class UserValidatorUseCase {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    private static  final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{1,13}$");
    private static final Pattern DOCUMENT_PATTERN = Pattern.compile("^[0-9]+$");

    public void validate(String firstName, String lastName, String identityNumber, String phoneNumber, LocalDate birthDate, String email, String password) {

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_FIRST_NAME);
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_LAST_NAME);
        }

        if (identityNumber == null || identityNumber.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_IDENTITY_NUMBER);
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_PHONE_NUMBER);
        }

        if (birthDate == null) {
            throw new EmptyException(DomainConstants.REQUIRED_BIRTH_DATE);
        }

        if (email == null || email.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_EMAIL);
        }

        if (password == null || password.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_PASSWORD);
        }


        if(!DOCUMENT_PATTERN.matcher(identityNumber).matches()) {
            throw new IdentityNumberException();
        }

        if (!PHONE_PATTERN.matcher(phoneNumber).matches()) {
            throw new PhoneNumberException();
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new EmailException();
        }

        if(Period.between(birthDate, LocalDate.now()).getYears() < DomainConstants.MIN_AGE) {
            throw new AgeInvalidException();
        }

    }

}
