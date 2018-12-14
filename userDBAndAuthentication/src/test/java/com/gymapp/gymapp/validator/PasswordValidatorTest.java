package com.gymapp.gymapp.validator;

import org.junit.Before;
import org.junit.Test;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @Before
    public void setUp() throws Exception {
        this.passwordValidator = new PasswordValidator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenPasswordIsNull() {
        //given
        String password = null;

        //when
        passwordValidator.validate(password);

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenPasswordIsEmpty() {
        //given
        String password = "";

        //when
        passwordValidator.validate(password);

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenPasswordContainsOnlySpaces() {
        //given
        String password = "   ";

        //when
        passwordValidator.validate(password);

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenPasswordIsTooShort() {
        //given
        String password = "a";

        //when
        passwordValidator.validate(password);

        //then
    }
}

