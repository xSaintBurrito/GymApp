package com.gymapp.gymapp.entity;

import com.gymapp.gymapp.Role;
import com.sun.istack.internal.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Transient
    private Set<Role> roles = new HashSet<>();

    @Transient
    private List<FitnessClass> fitnessClasses;

    protected User() {
    }

    public User(final String username,
                final String password,
                final Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles.addAll(roles);
    }

    public void grant(final Role role) {
        this.roles.add(role);
    }

    public void revoke(final Role role) {
        this.roles.remove(role);
    }

    public void updatePassword(final String newPassword) {
        this.password = newPassword;
    }

    public void updateUsername(final String newUsername) {
        this.username = newUsername;
    }

    public Set<Role> getRoles(){ return roles; }

    public List<FitnessClass> getFitnessClasses() { return  fitnessClasses; }

}
