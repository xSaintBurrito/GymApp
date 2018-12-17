public class TrainerTool {

    private Trainer trainer;

    public TrainerTool(Trainer trainer) {
        this.trainer = trainer;
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
        /*
            Logged in client can find activities where nb_max = 1, the client is on participants' list
            and the activity is conducted by the trainer whose profile he's visiting
            (Haven't figured it out yet)
         */
    }

    public void addClass(int month, int day, int hour, int nb_max, String activityName) {
        trainer.getTrainerCalendar().addActivity(month, day, hour, nb_max, activityName);
    }

    public void addPersonalTraining(int month, int day, int hour) {
        trainer.getTrainerCalendar().addActivity(month, day, hour, 1, "Personal training");
    }

    public void removeActivity(Activity ActivityToRemove) {
        trainer.getTrainerCalendar().deleteActivity(ActivityToRemove.getActivityId());
    }

    public void markAttendance(Activity activity, int userId, boolean participated) {
        Pair<int, boolean> attended;
        for(int i : activity.getParticipationList()) {
            if(i == userId) {
                attended = new Pair<>(userId, participated);
            }
        }
    }
}