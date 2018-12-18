package com.gymapp.gymapp;

import com.gymapp.gymapp.entity.FitnessClass;
import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.input.UserAddInput;

import java.util.Set;

public interface UserBO {
    boolean setRole(long id, Role role);
    boolean changePassword(long userId, String password);
    boolean isMatchingPassword(long userId, String password);
    User addUser(UserAddInput userAddInput);
    boolean deleteUser(long userId);
    boolean changeUsername(long userId, String newUsername);
    boolean addFitnessClass(long userId, FitnessClass fitnessClass);
    Role getUserRole(long userId);
}
