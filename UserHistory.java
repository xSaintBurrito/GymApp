import java.util.ArrayList;

public class UserHistory {

    private ArrayList<Activity> actHistory = new ArrayList<Activity>();
    private Activity activity;

    public void addTrainingPlan() {
        actHistory.add(activity);

    }

    /*
    public void getUserHistory() {
        this.actHistory = actHistory;
    }
    */
}
