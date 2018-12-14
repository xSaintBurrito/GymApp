package com.gymapp.gymapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Role {
    MANAGER(Authority.MANAGE_USERS,
            Authority.MODIFY_USERS,
            Authority.READ_USERS);
    //WORKER();

    private final List<Authority> authorities;

    Role(final Authority... authorities) {
        this.authorities = Arrays.asList(authorities);
    }

    public List<Authority> getAuthorities() {
        return Collections.unmodifiableList(authorities);
    }

}