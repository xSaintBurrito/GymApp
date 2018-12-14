package com.gymapp.gymapp.bo;

import com.gymapp.gymapp.FitnessClassBO;
import com.gymapp.gymapp.entity.FitnessClass;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.repository.FitnessClassRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FitnessClassBOImpl implements FitnessClassBO {

    private final FitnessClassRepository fitnessClassRepository;

    FitnessClassBOImpl(final FitnessClassRepository fitnessClassRepository) {
        this.fitnessClassRepository = fitnessClassRepository;
    }

    @Override
    public boolean isThereFitnessClassAtDate(LocalDateTime date) {
        List<FitnessClass> fitnessClasses = fitnessClassRepository.findAll().stream()
                .filter(fitnessClass -> date.isEqual(fitnessClass.checkDate()))
                .collect(Collectors.toList());

        return fitnessClasses.size() > 0;
    }

    @Override
    public List<User> whichUsersHaveClassesAtDate(LocalDateTime date) {
        List<FitnessClass> fitnessClasses = fitnessClassRepository.findAll().stream()
                .filter(fitnessClass -> date.isEqual(fitnessClass.checkDate()))
                .collect(Collectors.toList());

        List<User> activeUsers = new ArrayList<>();
        fitnessClasses.forEach(fitnessClass -> activeUsers.addAll(fitnessClass.getUsers()));
        return activeUsers;
    }

    @Override
    public boolean add(FitnessClass fitnessClass) {
        fitnessClassRepository.save(fitnessClass);
        return true;
    }

    @Override
    public boolean remove(FitnessClass fitnessClass) {
        fitnessClassRepository.delete(fitnessClass);
        return true;
    }
}
