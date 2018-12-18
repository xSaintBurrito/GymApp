package com.gymapp.gymapp;

import com.gymapp.gymapp.bo.UserBOImpl;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.factory.UserFactory;
import com.gymapp.gymapp.repository.UserRepository;
import com.gymapp.gymapp.validator.PasswordValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class GymappApplicationTests {
	@Test
	public void contextLoads() {

	}

}
