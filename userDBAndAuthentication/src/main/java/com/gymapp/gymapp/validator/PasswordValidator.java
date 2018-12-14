package com.gymapp.gymapp.validator;

import com.gymapp.gymapp.Constants;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    public void validate(final String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can not be null");
        }

        if (password.isEmpty()
                || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password can not be empty");
        }

        if (password.length() < Constants.MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password length has to be longer then " + Constants.MIN_PASSWORD_LENGTH);
        }
    }

}
