package com.gymapp.gymapp;

import com.gymapp.gymapp.entity.User;
import com.gymapp.gymapp.input.UserAddInput;

import java.util.Set;

public interface UserBO {
    boolean grantRole(long id, Role role);
    boolean revokeRole(long id, Role role);
    boolean changePassword(long userId, String password);
    boolean isMatchingPassword(long userId, String password);
    User addUser(UserAddInput userAddInput);
    boolean deleteUser(long userId);
    boolean changeUsername(long userId, String newUsername);
    Set<Role> getUserRoles(long userId);
}
