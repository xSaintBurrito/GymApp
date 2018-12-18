package com.gymapp.gymapp.factory;

import com.gymapp.gymapp.Role;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.input.UserAddInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserFactoryTest {

    private UserFactory userFactory;

    @Mock
    private PasswordEncoder passwordEncoder;

    private long id;
    private String username;
    private String password;

    @Before
    public void setUp() throws Exception {
        this.id = 1L;
        this.username = "username";
        this.password = "password";
        this.userFactory = new UserFactory(passwordEncoder);
    }

    @After
    public void tearDown() throws Exception {
        this.id = 1L;
        this.userFactory = null;
        this.password = null;
        this.username = null;
    }

    @Test
    public void shouldReturnUserInCreateWithoutRoles() {
        //given
        String encryptedPassword = "hash";
        UserAddInput userAddInput = UserAddInput.builder()
                .username(username)
                .password(password)
                .role(Role.MANAGER)
                .build();
        when(passwordEncoder.encode(password))
                .thenReturn(encryptedPassword);

        //when
        User result = userFactory.create(userAddInput);

        //then
        verify(passwordEncoder)
                .encode(password);

        assertThat(result)
                .isNotNull();
        assertThat(result)
                .isNotNull();
        assertThat(result.getUsername())
                .isEqualTo(username);
        assertThat(result.getPassword())
                .isEqualTo(encryptedPassword);
        assertThat(result.getRole())
                .isNotNull()
                .isEqualTo(Role.MANAGER);
    }

    @Test
    public void shouldReturnUserInCreateWithRoles() {
        //given
        Role role = Role.MANAGER;
        UserAddInput userAddInput = UserAddInput.builder()
                .username(username)
                .password(password)
                .role(role)
                .build();
        String encryptedPassword = "hash";
        when(passwordEncoder.encode(password))
                .thenReturn(encryptedPassword);

        //when
        User result = userFactory.create(userAddInput);

        //then
        verify(passwordEncoder)
                .encode(password);

        assertThat(result)
                .isNotNull();
        assertThat(result)
                .isNotNull();
        assertThat(result.getUsername())
                .isEqualTo(username);
        assertThat(result.getPassword())
                .isEqualTo(encryptedPassword);
        assertThat(result.getRole())
                .isNotNull()
                .isEqualTo(role);
    }
}

