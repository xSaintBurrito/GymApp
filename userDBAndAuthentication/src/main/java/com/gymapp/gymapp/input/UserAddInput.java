package com.gymapp.gymapp.input;

import com.gymapp.gymapp.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class UserAddInput {

    private final long employeeId;
    private final String username;
    private final String password;
    private final Collection<Role> roles;
}

