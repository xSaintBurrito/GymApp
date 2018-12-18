import java.util.Calendar;
import java.util.Date;

public class GymPass {
    private int gymPassID;
    private Calendar startDate;
    private Calendar endDate;
    private Calendar today;

    //constructor
    public GymPass(int gymPassID, int month, int day, int hour)
    {
        this.gymPassID = gymPassID;

        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.MONTH, month-1);
        rightNow.set(Calendar.DAY_OF_MONTH, day);
        rightNow.set(Calendar.HOUR_OF_DAY,hour);
        this.startDate=rightNow;

        Calendar notrightNow = Calendar.getInstance();
        notrightNow.set(Calendar.MONTH, month+5);
        notrightNow.set(Calendar.DAY_OF_MONTH, day);
        notrightNow.set(Calendar.HOUR_OF_DAY,hour);
        this.endDate=notrightNow;

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        this.today = today;
    }

    //methods
    public void ExtendGymPass()
    {
        int month = today.get(Calendar.MONTH);
        int day = today.get(Calendar.DAY_OF_MONTH);
        int hour = today.get(Calendar.HOUR);

        startDate = endDate;
        Calendar extend = Calendar.getInstance();
        extend.set(Calendar.MONTH, month+6);
        extend.set(Calendar.DAY_OF_MONTH, day);
        extend.set(Calendar.HOUR_OF_DAY,hour);
        endDate = extend;
    }

    public boolean isValid()
    {
        if (endDate.compareTo(today) >= 0)
            return true;
        else
            return false;
    }
}
