package com.gymapp.gymapp.input;

import com.gymapp.gymapp.Role;
import com.gymapp.gymapp.entity.FitnessClass;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class UserAddInput {

    private final String username;
    private final String password;
    private final Role role;
    private final List<FitnessClass> fitnessClasses;
}

