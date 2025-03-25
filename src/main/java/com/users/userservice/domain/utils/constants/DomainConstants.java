package com.users.userservice.domain.utils.constants;

public class DomainConstants {

    private DomainConstants(){}

    public static final String REQUIRED_FIRST_NAME = "El nombre es obligatorio.";
    public static final String REQUIRED_LAST_NAME = "El apellido es obligatorio.";
    public static final String REQUIRED_IDENTITY_NUMBER = "El documento es obligatorio.";
    public static final String REQUIRED_PHONE_NUMBER = "El telefono es obligatorio.";
    public static final String REQUIRED_BIRTH_DATE = "La fecha de nacimiento es obligatoria.";
    public static final String REQUIRED_EMAIL = "El email es obligatorio.";
    public static final String REQUIRED_PASSWORD = "La cotraseña es obligatoria.";
    public static final int MIN_AGE = 18;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String REGEX_PHONE_NUMBER = "^\\+?[0-9]{1,13}$";
    public static final String REGEX_IDENTITY_NUMBER = "^[0-9]+$";

    public static final String REQUIRED_NAME_ROLE = "El nombre del role es obligatorio.";
    public static final String REQUIRED_DESCRIPTION_ROLE = "La descripcion del role es obligatoria.";

    public static final int MAX_LENGTH_NAME_ROLE = 20;
    public static final int MAX_LENGTH_DESCRIPTION_ROLE = 50;

}
