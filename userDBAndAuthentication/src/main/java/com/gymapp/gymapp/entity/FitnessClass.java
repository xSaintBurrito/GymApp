package com.gymapp.gymapp.entity;

import com.sun.istack.internal.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class FitnessClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private long maxPlaces;

    @NotNull
    private LocalDateTime date;

    private long trainerId;

    //@Transient
    @ManyToMany(mappedBy = "fitnessClasses")
    private List<User> signedUsers;

    protected FitnessClass(){

    }

    public FitnessClass(final long maxPlaces, final LocalDateTime date, final long trainerId) {
        this.maxPlaces = maxPlaces;
        this.date = date;
        this.trainerId = trainerId;
        this.signedUsers = new ArrayList<>();
    }

    public LocalDateTime checkDate(){ return date; }

    public boolean checkForPlaces(){
        return signedUsers.size() < maxPlaces;
    }

    public void signUp(final User user){
        signedUsers.add(user);
    }

    public void signOff(final User user){
        signedUsers.remove(user);
    }

    public List<User> getUsers(){ return signedUsers; }

}
