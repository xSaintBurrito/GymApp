package com.gymapp.gymapp.factory;

import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.input.UserAddInput;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    private final PasswordEncoder passwordEncoder;

    public UserFactory(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User create(final UserAddInput userAddInput) {
        String passwordEncrypted = passwordEncoder.encode(userAddInput.getPassword());

        return new User(userAddInput.getUsername(), passwordEncrypted, userAddInput.getRole(), userAddInput.getFitnessClasses());
    }
}
