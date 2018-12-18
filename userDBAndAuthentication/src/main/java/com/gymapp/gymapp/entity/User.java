package com.gymapp.gymapp.entity;

import com.gymapp.gymapp.Role;
import com.sun.istack.internal.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Role role;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "users_fitness_class",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "fitness_class_id") }
    )
    private List<FitnessClass> fitnessClasses;

    protected User() {
    }

    public User(final String username,
                final String password,
                final Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fitnessClasses = new ArrayList<FitnessClass>();
    }

    public User(final String username,
                final String password,
                final Role role,
                final List<FitnessClass> fitnessClasses) {
        this.username = username;
        this.password = password;
        this.role = role;
        if(fitnessClasses == null)
            this.fitnessClasses = new ArrayList<FitnessClass>();
        else
            this.fitnessClasses = fitnessClasses;
    }

    public void setRole(final Role role) { this.role = role; }

    public void updatePassword(final String newPassword) {
        this.password = newPassword;
    }

    public void updateUsername(final String newUsername) {
        this.username = newUsername;
    }

    public Role getRole(){ return role; }

    public List<FitnessClass> getFitnessClasses() { return  fitnessClasses; }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses){ this.fitnessClasses = fitnessClasses; }

    public void addFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.add(fitnessClass);
        fitnessClass.getUsers().add(this);
    }

}
