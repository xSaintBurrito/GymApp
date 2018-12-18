package com.gymapp.gymapp.entity;

import com.gymapp.gymapp.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private Long id;
    private String username;
    private String password;
    private Role role;

    @Before
    public void setUp() throws Exception {
        this.id = 1L;
        this.username = "user";
        this.password = "password";
        this.role = Role.MANAGER;
    }

    @After
    public void tearDown() throws Exception {
        this.id = null;
        this.username = null;
        this.password = null;
        this.role = null;
    }

    @Test
    public void shouldCreateUser() {
        //given

        //when
        User result = new User(username, password, role);

        //then
        assertThat(result)
                .isNotNull();
        assertThat(result)
                .isNotNull();
        assertThat(result.getUsername())
                .isEqualTo(username);
        assertThat(result.getPassword())
                .isEqualTo(password);
        assertThat(result.getRole())
                .isNotNull()
                .isEqualTo(role);
    }

    @Test
    public void shouldGrantRole() {
        //given
        Role role = Role.MANAGER;
        User user = new User(username, password, Role.MANAGER);

        //when
        user.setRole(role);

        //then
        assertThat(user)
                .isNotNull();
        assertThat(user.getRole())
                .isNotNull()
                .isEqualTo(role);
    }
}
