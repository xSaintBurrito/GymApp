package gymAppCalendar;
import java.util.ArrayList;

public class UserCalendar 
{
	private int userId;															
	private ArrayList<Integer> userCalendar = new ArrayList<Integer>();				
																		
		

	
	public UserCalendar(int userId) 
	{
		this.userId = userId;
		this.userCalendar = new ArrayList<Integer>();
	}

	private ArrayList<Integer> sortActivityList () 
	{
		ArrayList<Integer> order = new ArrayList<Integer>();
		if (this.userCalendar.size()!=0) 
		{
			int eject;
			while (this.userCalendar.size()!=0) 
			{
				eject=this.userCalendar.get(0);
				for (int i=0; i < this.userCalendar.size() ; i++) 
				{
					if (FullCalendar.getActivity(this.userCalendar.get(i)).getDate().before(FullCalendar.getActivity(eject).getDate())) 
					{
						eject=this.userCalendar.get(i);
					}
				}
				order.add(eject);
				this.userCalendar.remove(this.userCalendar.indexOf(eject));
			}
			this.userCalendar=order;
		}	
		return this.userCalendar;
	}
	
	public void displayCalendar()
	{
		for(int i=0;i<this.userCalendar.size();i++)
		{
			try 
			{
				FullCalendar.getActivity(this.userCalendar.get(i)).displayActivity();
			}
			catch (NullPointerException e)
			{
				this.userCalendar.remove(i);
				System.out.println("Beware, one of your activites had been deleted by the trainer");
			}
		}
	}

	
	public ArrayList<Integer> getUserCalendar() 			
	{					
		return this.userCalendar;
	}
	
	public int getuserId() 
	{
		return this.userId;
	}
	public void bookActivity(int activityId) 								
	{
		if(FullCalendar.getActivity(activityId).clientBooking(this.userId))
		{
			this.userCalendar.add(activityId);
			sortActivityList();
		}
	}
	public void cancelReservation(int activityId) 
	{
		if (userCalendar.contains(activityId))
		{
			FullCalendar.getActivity(activityId).clientCancel(this.userId);
			this.userCalendar.remove(this.userCalendar.indexOf(activityId));
		}
		else
		{
			System.out.println("You didn't book this activity");
		}
	}
}

								



