package com.gymapp.gymapp.bo;

import com.gymapp.gymapp.Role;
import com.gymapp.gymapp.bo.UserBOImpl;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.factory.UserFactory;
import com.gymapp.gymapp.input.UserAddInput;
import com.gymapp.gymapp.repository.UserRepository;
import com.gymapp.gymapp.validator.PasswordValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserBOImplTest {

    private UserBOImpl userBOImpl;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFactory userFactory;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private PasswordValidator passwordValidator;

    private long id;
    private String username;
    private String password;
    private List<Role> roles;

    @Before
    public void setUp() throws Exception {
        this.userBOImpl = new UserBOImpl(userRepository,
                userFactory,
                passwordEncoder,
                passwordValidator);

        this.id = 1L;
        this.username = "user";
        this.password = "password";
        this.roles = Arrays.asList(Role.MANAGER);
    }

    @After
    public void tearDown() throws Exception {
        this.userBOImpl = null;
    }

    @Test
    public void shouldAddUserWithoutRoles() {
        //given
        User user = mock(User.class);
        UserAddInput userAddInput = UserAddInput.builder()
                .username(username)
                .password(password)
                .roles(Collections.emptySet())
                .build();
        when(userFactory.create(userAddInput))
                .thenReturn(user);
        when(userRepository.save(user))
                .thenReturn(user);

        //when
        User result = userBOImpl.addUser(userAddInput);

        //then
        verify(userFactory)
                .create(userAddInput);
        verify(userRepository)
                .save(user);
        assertThat(result)
                .isNotNull();
    }

    @Test
    public void shouldAddUserWithRoles() {
        //given
        User user = mock(User.class);
        UserAddInput userAddInput = UserAddInput.builder()
                .username(username)
                .password(password)
                .roles(roles)
                .build();
        when(userFactory.create(userAddInput))
                .thenReturn(user);
        when(userRepository.save(user))
                .thenReturn(user);

        //when
        User result = userBOImpl.addUser(userAddInput);

        //then
        verify(userFactory)
                .create(userAddInput);
        verify(userRepository)
                .save(user);
        assertThat(result)
                .isNotNull();
    }

    @Test
    public void shouldGrantRoleToUser() {
        //given
        Role role = Role.MANAGER;
        User user = mock(User.class);

        when(userRepository.getOne(id))
                .thenReturn(user);

        //when
        userBOImpl.grantRole(id, role);

        //then
        verify(userRepository)
                .getOne(id);
        verify(user)
                .grant(role);
    }

    @Test
    public void shouldRevokeRoleFromUser() {
        //given
        Role role = Role.MANAGER;
        User user = mock(User.class);

        when(userRepository.getOne(id))
                .thenReturn(user);

        //when
        userBOImpl.revokeRole(id, role);

        //then
        verify(userRepository)
                .getOne(id);
        verify(user)
                .revoke(role);
    }

    @Test
    public void shouldDelete() {
        //given

        //when
        userBOImpl.deleteUser(1L);

        //then
        verify(userRepository)
                .deleteById(1L);
    }

    @Test
    public void shouldChangePassword() {
        //given
        String userName = "user";
        String newPassword = "newPassword";
        String newHash = "newHash";
        User user = mock(User.class);

        when(userRepository.getOne(id))
                .thenReturn(user);
        when(passwordEncoder.encode(newPassword))
                .thenReturn(newHash);

        //when
        userBOImpl.changePassword(id, newPassword);

        //then
        verify(user)
                .updatePassword(newHash);
    }

}
