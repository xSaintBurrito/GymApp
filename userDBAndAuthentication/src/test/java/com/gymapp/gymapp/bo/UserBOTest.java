package com.gymapp.gymapp.bo;

import com.gymapp.gymapp.FitnessClassBO;
import com.gymapp.gymapp.Role;
import com.gymapp.gymapp.UserBO;
import com.gymapp.gymapp.entity.FitnessClass;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.input.UserAddInput;
import com.gymapp.gymapp.repository.FitnessClassRepository;
import com.gymapp.gymapp.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest() //classes = Application.class
public class UserBOTest {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";
    private static final Role ROLE = Role.MANAGER;
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
                .role(ROLE)
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

