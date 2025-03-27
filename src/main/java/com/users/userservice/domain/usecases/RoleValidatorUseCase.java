package com.users.userservice.domain.usecases;

import com.users.userservice.domain.exceptions.EmptyException;
import com.users.userservice.domain.exceptions.MaxLengthDescriptionRole;
import com.users.userservice.domain.exceptions.MaxLengthNameRole;
import com.users.userservice.domain.utils.constants.DomainConstants;

public class RoleValidatorUseCase {

    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_NAME_ROLE);
        }
        if (name.length() > DomainConstants.MAX_LENGTH_NAME_ROLE) {
            throw new MaxLengthNameRole();
        }
    }

    public void validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new EmptyException(DomainConstants.REQUIRED_DESCRIPTION_ROLE);
        }
        if (description.length() > DomainConstants.MAX_LENGTH_DESCRIPTION_ROLE) {
            throw new MaxLengthDescriptionRole();
        }
    }
}
