package com.gymapp.gymapp.bo;

import com.gymapp.gymapp.Role;
import com.gymapp.gymapp.UserBO;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.input.UserAddInput;
import com.gymapp.gymapp.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest() //classes = Application.class
public class UserBOTest {

    private static final Long ID = 1L;
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final Role ROLE_MANAGER = Role.MANAGER;
    @Autowired
    private UserBO userBO;
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Before
    public void setUp() {
        UserAddInput userAddInput = UserAddInput.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .employeeId(ID)
                .roles(Collections.emptySet())
                .build();
        user = userBO.addUser(userAddInput);
    }

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
        user = null;
    }

    @Test
    public void shouldChangePassword() {
        //given
        String newPassword = "NEW_PASSWORD";
        //when
        userBO.changePassword(user.getId(), newPassword);
        //
        assertThat(userBO.isMatchingPassword(user.getId(), newPassword))
                .isTrue();
    }

    @Test
    public void shouldCheckPasswordAndReturnTrue() {
        //given
        //when
        boolean result = userBO.isMatchingPassword(user.getId(), PASSWORD);
        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldCheckPasswordAndReturnFalse() {
        //given
        //when
        boolean result = userBO.isMatchingPassword(user.getId(), "NOT_A_PASSWORD");
        //then
        assertThat(result).isFalse();
    }
}

