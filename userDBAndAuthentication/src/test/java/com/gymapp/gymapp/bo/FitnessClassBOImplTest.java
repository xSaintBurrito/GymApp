package com.gymapp.gymapp.bo;

import com.gymapp.gymapp.entity.FitnessClass;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.repository.FitnessClassRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FitnessClassBOImplTest {

    private FitnessClassBOImpl fitnessClassBOImpl;

    @Mock
    private FitnessClassRepository fitnessClassRepository;

    private Long id;
    private long maxPlaces;
    private LocalDateTime date;
    private long trainerId;
    private List<User> signedUsers;
    private String username;
    private String password;

    @Before
    public void setUp() throws Exception {
        this.fitnessClassBOImpl = new FitnessClassBOImpl(fitnessClassRepository);

        this.id = 1L;
        this.username = "user";
        this.password = "password";
        this.maxPlaces = 100;
        this.date = LocalDateTime.of(2010, 10, 10, 10, 10);
        this.trainerId = 1L;

    }

    @After
    public void tearDown() throws Exception {
        this.fitnessClassBOImpl = null;
    }

    @Test
    public void shouldAddFitnessClass() {
        //given
        FitnessClass fitnessClass = mock(FitnessClass.class);
        when(fitnessClassRepository.save(fitnessClass))
                .thenReturn(fitnessClass);

        //when
        boolean result = fitnessClassBOImpl.add(fitnessClass);

        //then
        assertThat(result)
                .isTrue();

    }

    @Test
    public void shouldRemoveFitnessClass() {
        //given
        FitnessClass fitnessClass = new FitnessClass(maxPlaces, date, trainerId);
        fitnessClassBOImpl.add(fitnessClass);

        //when
        boolean result = fitnessClassBOImpl.remove(fitnessClass);

        //then
        assertThat(result)
                .isTrue();
    }

}
