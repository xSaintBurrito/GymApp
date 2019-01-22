/* REQUIRES GYMAPP/CALENDAR AND GYMAPP/CLIENT */


import calendarClasses.*;
import clientClasses.*;
import javafx.util.Pair;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TrainerTool {

    private FullCalendar fullCalendar;
    private Trainer trainer;

    public TrainerTool(Trainer trainer, FullCalendar fullCalendar) {
        this.trainer = trainer;
        this.fullCalendar = fullCalendar;
    }

    public void showProfile() {
        System.out.println(trainer.getName());
        System.out.println(trainer.getBio());
    }

    public void showTrainersClasses() {
        System.out.println("Upcoming classes for " + trainer.getName() + ":");
        trainer.getTrainerCalendar().displayCalendar();
    }

    public void showClientsTrainings(Client client) {
        for(int id : trainer.getTrainerCalendar().getTrainerCalendar())
        {
            if(FullCalendar.getActivity(id).getNb_max() == 1 && FullCalendar.getActivity(id).getTrainerId() == this.trainer.getTrainerId())
            {
                if(FullCalendar.getActivity(id).getParticipationList()[0] == client.getUserId() && FullCalendar.getActivity(id).getActivityName().equals("Personal training"))
                {
                    System.out.print("Your personal training with " + trainer.getName() + " is on " + FullCalendar.getActivity(id).getDate().toString());
                }
            }
        }
    }

    public void addClass(int month, int day, int hour, int nb_max, String activityName) {
        trainer.getTrainerCalendar().addNewActivity(month, day, hour, nb_max, activityName);
    }

    public void addPersonalTraining(int month, int day, int hour, Client client) {
        trainer.getTrainerCalendar().addNewActivity(month, day, hour, 1, "Personal training with" + client.getName());
    }

    public void removeActivity(Activity ActivityToRemove) {
        trainer.getTrainerCalendar().deleteActivity(ActivityToRemove.getActivityId());
    }

    public void markAttendance(Activity activity, Client client, boolean participated) {
        Pair<Integer, Boolean> attended = null;
        for(int i : activity.getParticipationList()) {
            if(i == client.getUserId()) {
                attended = new Pair<>(client.getUserId(), participated);
                //activity.getAttendance.add(attended);
            }
        }
    }
}