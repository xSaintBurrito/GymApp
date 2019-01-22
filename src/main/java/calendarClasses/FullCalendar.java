package calendarClasses;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class FullCalendar 
{
	//ATTRIBUTES
	protected static Map <Integer,Activity> fullCalendar = new HashMap<>();
	private static int counter = 0;
	
	
	//METHODS FOR TRAINERCALENDAR
	static protected int createActivity(int month, int day, int hour, int nb_max, String activityName, int trainerId)
	{
		fullCalendar.put(counter, new Activity(month, day, hour, nb_max, activityName, trainerId, counter));
		int Id = counter;
		counter++;
		return Id;
	}
	
	static protected void deleteActivity(int activityId)
	{
		fullCalendar.remove(activityId);				//activit� supprim�e mais clients pas prevenus, essayer de voir si faisable
	}
	
	//ACCESS A SPECIFIC ACTIVITY WITH ID
	static public Activity getActivity(int activityId)
	{
		return fullCalendar.get(activityId);
	}
	
	//CALENDAR DISPLAY METHODS
	static public void displayCalendarHour(int month, int day,int hour)  //display activities occurring at a given hour
	{
		if((month%2==0 && day>30)||(day >31)||(month==2 && day>28)||(hour>23)||(month<1)||(day<1)||(hour<0)||(month>12))
		{
			System.out.println("This date doesn't exist");
		}
		for(Map.Entry<Integer, Activity> entry: fullCalendar.entrySet()) 
		{
			if(entry.getValue().getDate().get(Calendar.HOUR_OF_DAY)==hour && entry.getValue().getDate().get(Calendar.DAY_OF_MONTH)==day && entry.getValue().getDate().get(Calendar.MONTH)+1==month)
			{
				entry.getValue().displayActivity();
			}
		}
	}
	
	static public void displayCalendarDay(int month, int day)//display activities occurring on a given day
	{
		if((month%2==0 && day>30)||(day >31)||(month==2 && day>28)||(month<1)||(day<1)||(month>12))
		{
			System.out.println("This date doesn't exist");
		}
		for(int i=0;i<24;i++)
		{
			displayCalendarHour(month, day, i);
		}
	}
	static public void displayCalendarMonth(int month) //display activities occurring on a given month
	{
		int max=0;
		if(month%2==1 && month<13)
		{
			max = 31;
		}
		else if (month==2)
		{
			max = 28;
		}
		else if (month%2==0 && month<13)
		{
			max = 30;
		}
		else
		{
			System.out.println("This date doesn't exist");
		}
		for(int i=1;i<max+1;i++)
		{
			displayCalendarDay(month,i);
		}
	}	
	
	//Display activities selected (with their name)	
	static public void displayCalendarHour(int month, int day,int hour, String name)  //display activities occurring at a given hour
	{
		if((month%2==0 && day>30)||(day >31)||(month==2 && day>28)||(hour>23)||(month<1)||(day<1)||(hour<0)||(month>12))
		{
			System.out.println("This date doesn't exist");
		}
		for(Map.Entry<Integer, Activity> entry: fullCalendar.entrySet()) 
		{
			if(entry.getValue().getDate().get(Calendar.HOUR_OF_DAY)==hour && entry.getValue().getDate().get(Calendar.DAY_OF_MONTH)==day && entry.getValue().getDate().get(Calendar.MONTH)+1==month && entry.getValue().getActivityName()==name)
			{
				entry.getValue().displayActivity();
			}
		}
	}
	
	static public void displayCalendarDay(int month, int day, String name) //display activities occurring on a given day
	{
		if((month%2==0 && day>30)||(day >31)||(month==2 && day>28)||(month<0)||(day<1)||(month>12))
		{
			System.out.println("This date doesn't exist");
		}
		for(int i=0;i<24;i++)
		{
			displayCalendarHour(month, day,i, name);
		}
	}
	static public void displayCalendarMonth(int month, String name)  //display activities occurring on a given month
	{
		int max=0;
		if(month%2==1 && month<13)
		{
			max = 31;
		}
		else if (month==2)
		{
			max = 28;
		}
		else if (month%2==0 && month<13)
		{
			max = 30;
		}
		else
		{
			System.out.println("This date doesn't exist");
		}
		for(int i=1;i<max+1;i++)
		{
			displayCalendarDay(month,i,name);
		}
	}	
}
	
