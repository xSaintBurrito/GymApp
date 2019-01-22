/* REQUIRES GYMAPP/CALENDAR AND GYMAPP/CLIENT */

import calendarClasses.TrainerCalendar;

import java.util.concurrent.ThreadLocalRandom;

public class Trainer {

    private String name;
    private String bio;
    private int trainerId;
    private TrainerCalendar trainerCalendar;

    public Trainer() {
        trainerId = ThreadLocalRandom.current().nextInt(1000, 2000);
        trainerCalendar = new TrainerCalendar(trainerId);
    }

    public Trainer(String name, String bio) {
        trainerId = ThreadLocalRandom.current().nextInt(1000, 2000);
        trainerCalendar = new TrainerCalendar(trainerId);
        this.name = name;
        this.bio = bio;
    }


    public String getName() {
        return name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public TrainerCalendar getTrainerCalendar() {
        return trainerCalendar;
    }
}
