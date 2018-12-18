import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;



public class UserPanel {

    private int userID;
    private String userName;
    private ArrayList<History> history;
    private Activity activity; //object from Calendar
    private GymPass gymPass;




    //constructor
    public UserPanel(int userID, String userName, ArrayList<History> history) {
        this.userID = userID;
        this.userName = userName;
        this.history = history;
    }


    //methods
    public void addClasses()
    {
        activity.clientBooking(userID);
    }

    public void removeClasses()
    {
        activity.clientCancel(userID);
    }

    /*
    public void addPersonalTraining()
    {
    }
    */

    public void viewTrainingHistory()
    {
        System.out.println("Viewing User History: ");
        System.out.println("----------------------");
        Iterator<History> it;
        it = history.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public void getGymPass()
    {
        if (gymPass.isValid())
            System.out.println("Your GymPass is still valid");
        else
            gymPass.ExtendGymPass();
    }

    /*
    public boolean gymEquipStatus()
    {
        //waiting for the implementation of the database
    }
    */
}
