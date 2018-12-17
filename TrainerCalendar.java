import java.util.ArrayList;

public class TrainerCalendar 
{
	private int trainerId;
	private ArrayList<Integer> trainerCalendar = new ArrayList<Integer>();

	
	public TrainerCalendar(int trainerId) 
	{
		this.trainerId = trainerId;
		this.trainerCalendar = new ArrayList<Integer>();
	}
	
	
	private ArrayList<Integer> sortActivityList () 
	{
		ArrayList<Integer> order = new ArrayList<Integer>();
		if (trainerCalendar.size()!=0) 
		{
			int eject;
			while (trainerCalendar.size()!=0) 
			{
				eject=trainerCalendar.get(0);
				for (int i=0; i < trainerCalendar.size() ; i++) 
				{
					if (FullCalendar.getActivity(trainerCalendar.get(i)).getDate().before(FullCalendar.getActivity(eject).getDate())) 
					{
						eject=trainerCalendar.get(i);
					}
				}
				order.add(eject);
				trainerCalendar.remove(trainerCalendar.indexOf(eject));
			}
			trainerCalendar=order;
		}	
		return this.trainerCalendar;
	}
	
	public void displayCalendar()
	{
		sortActivityList();
		for(int i=0;i<trainerCalendar.size();i++)
		{
			FullCalendar.getActivity(trainerCalendar.get(i)).displayActivity();;
		}
	}

	public void addNewActivity(int month, int day, int hour, int nb_max, String activityName)
	{
		trainerCalendar.add(FullCalendar.createActivity(month, day, hour, nb_max, activityName, trainerId));
	}

	public void deleteActivity(int cancelledActivityId) 
	{	
		if (trainerCalendar.contains(cancelledActivityId))
		{
			trainerCalendar.remove(trainerCalendar.indexOf(cancelledActivityId));
			FullCalendar.deleteActivity(cancelledActivityId);
		}
		else
		{
			System.out.println("You don't own this activity");
		}
	}
	
	public void printParticipationList(int activityId)
	{
		if (trainerCalendar.contains(activityId))
		{
			System.out.println("Participation List to activity with Id " + activityId);
			FullCalendar.getActivity(this.trainerCalendar.get(activityId)).getParticipationList();
		}
		else
		{
			System.out.println("You don't own this activity");
		}
	}

	public ArrayList<Integer> getTrainerCalendar() {
		return trainerCalendar;
	}
}





