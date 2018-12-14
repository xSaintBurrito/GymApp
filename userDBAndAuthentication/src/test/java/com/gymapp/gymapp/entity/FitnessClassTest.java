package com.gymapp.gymapp.entity;

import com.gymapp.gymapp.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FitnessClassTest {

    private Long id;
    private long maxPlaces;
    private LocalDateTime date;
    private long trainerId;
    private List<User> signedUsers;
    private String username;
    private String password;

    @Before
    public void setUp() throws Exception {
        this.id = 1L;
        this.username = "user";
        this.password = "password";
        this.maxPlaces = 100;
        this.date = LocalDateTime.of(2010, 10, 10, 10, 10);
        this.trainerId = 1L;
    }

    @After
    public void tearDown() throws Exception {
        this.id = null;
        this.maxPlaces = 100;
        this.date = null;
        this.signedUsers = null;
    }

    @Test
    public void shouldCreateFitnessClass() {
        //given

        //when
        FitnessClass fitnessClass = new FitnessClass(maxPlaces, date, trainerId);

        //then
        assertThat(fitnessClass)
                .isNotNull();
        assertThat(fitnessClass.getDate())
                .isEqualTo(date);
        assertThat(fitnessClass.getMaxPlaces())
                .isEqualTo(maxPlaces);
        assertThat(fitnessClass.getTrainerId())
                .isEqualTo(trainerId);
    }

    @Test
    public void shouldSignUpForFitnessClass() {
        //given
        User user = new User(username, password, Collections.emptyList());
        FitnessClass fitnessClass = new FitnessClass(maxPlaces, date, trainerId);


        //when
        fitnessClass.signUp(user);

        //then
        assertThat(fitnessClass)
                .isNotNull();
        assertThat(fitnessClass.getSignedUsers())
                .contains(user);
    }

    @Test
    public void shouldSignOffFromFitnessClass() {
        //given
        User user = new User(username, password, Collections.emptyList());
        FitnessClass fitnessClass = new FitnessClass(maxPlaces, date, trainerId);
        fitnessClass.signUp(user);

        //when
        fitnessClass.signOff(user);

        //then
        assertThat(fitnessClass)
                .isNotNull();
        assertThat(fitnessClass.getSignedUsers())
                .doesNotContain(user);
    }

}
