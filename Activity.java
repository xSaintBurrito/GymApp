import java.util.Calendar;

public class Activity 						 
{															//Il faut rajouter des méthodes d'accès aux activités depuis fullCalendar
    private int activityId;
	private int trainerId;
	private int nb_max;
	int[] userId; 							
	private int nb_registers;
	private String activityName;
	private Calendar date;


	//CONSTRUCTOR
	public Activity(int month, int day, int hour, int nb_max, String activityName, int trainerId, int activityId)
	{
		this.activityId=activityId;
		this.trainerId=trainerId;
		this.nb_max = nb_max;
		this.userId= new int[nb_max];
		this.nb_registers=0;
		this.activityName=activityName;
		
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.MONTH, month-1);
		rightNow.set(Calendar.DAY_OF_MONTH, day);
		rightNow.set(Calendar.HOUR_OF_DAY,hour);
		this.date=rightNow;
		
	}
	//GETTERS
	public int getActivityId()
	{
		return this.activityId;
	}
	
	public int getTrainerId()
	{
		return this.trainerId;
	}
	
	public int getNb_max()
	{
		return this.nb_max;
	}
	
	public int getNb_registers()
	{
		return this.nb_registers;
	}

	public void getParticipationList() 					
	{
		for (int i=0;i<this.nb_registers;i++)
		{
			System.out.println("->User with Id "+this.userId[i]);
		}
		
	}
	
	public Calendar getDate()
	{
		return this.date;
	}
	
	public String getActivityName()
	{
		return this.activityName;
	}
	
	//METHODS FOR USERCALENDAR
	public boolean clientBooking(int newUserId)
	{
		if (this.nb_registers>=this.nb_max)
		{
			System.out.println("Sorry, this activity is already full");
			return false;
		}
		else
		{									
			this.userId[nb_registers]=newUserId;
			this.nb_registers++;	
			return true;
		}
	}
	
	public void clientCancel(int newUserId)
	{
		int rank=0;
		int found=0;
		for(int i=0;i<this.nb_registers;i++)
		{
			if(this.userId[i]==newUserId)
			{
				rank=i;
				found=1;
			}
		}
		if (found==1)
		{
			this.userId[rank]=this.userId[this.nb_registers-1];
			this.nb_registers--;
		}		
	}
	
	// Display an Activity
	public void displayActivity()	
	{
		if (this.nb_registers>=this.nb_max)
		{
			System.out.println("On " + this.getDate().get(Calendar.DAY_OF_MONTH) + "/" + (this.getDate().get(Calendar.MONTH)+1) + " at " + this.getDate().get(Calendar.HOUR_OF_DAY) + ":00 " + " -> " + this.activityName + " !! FULL !!" + "     ActivityID : " + this.activityId);
		}
		else
		{
			System.out.println("On " + this.getDate().get(Calendar.DAY_OF_MONTH) + "/" + (this.getDate().get(Calendar.MONTH)+1) + " at " + this.getDate().get(Calendar.HOUR_OF_DAY) + ":00 " + " -> " + this.activityName + ", " + (this.nb_max-this.nb_registers) + " remaining spots" + "     ActivityID : " + this.activityId);
		}
	}
	
}