package com.gymapp.gymapp;

import com.gymapp.gymapp.entity.FitnessClass;
import com.gymapp.gymapp.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface FitnessClassBO {
    boolean isThereFitnessClassAtDate(final LocalDateTime date);
    List<User> whichUsersHaveClassesAtDate(final LocalDateTime date);
    boolean add(final FitnessClass fitnessClass);
    boolean remove(final FitnessClass fitnessClass);
}
