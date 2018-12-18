package gymAppCalendar;
public class TestCalendar
{
	public static void main(String[] args)
	{		
		//TESTS FOR USER AND TRAINER CALENDARS
		UserCalendar u0 = new UserCalendar(00000000);			//
		UserCalendar u1 = new UserCalendar(00000001);			//new clients with IDS 0,1,2 and 3
		UserCalendar u2 = new UserCalendar(00000002);			//
		UserCalendar u3 = new UserCalendar(00000003);
		
		TrainerCalendar t0 = new TrainerCalendar(00000000); 	//new trainers with IDS 0 and 1
		TrainerCalendar t1 = new TrainerCalendar(00000001);		//
		
		t0.addNewActivity(12, 25, 0, 3, "Christmas Yoga");		//t0 creates a yoga activity on 25/12 at midnight, 3 spots
		t1.addNewActivity(12, 28, 1, 4, "Boxing");				//t1 creates a boxing activity on 28/12 at 1am, 4 spots
		
		System.out.println("/ Full Calendar /");
		FullCalendar.displayCalendarMonth(12);					//any client can display these 2 activities using this line of code (12 is the month)
		System.out.println("/ Full Calendar /");
		System.out.println("");
		
		//USER TESTS --------------------------------------------------------------------------------------------------------------------
		
		u0.bookActivity(0);										//
		u1.bookActivity(0);										//u0 u1 and u2 saw that there was an awesome activity named "Christmas Yoga"
		u2.bookActivity(0);										//and with ActivityID=0, so they book it
		
		u0.bookActivity(1); 									//u0 also wants to do some boxing 
	
		System.out.println("/ Full Calendar after 3 bookings for yoga and 1 booking for boxing /");
		FullCalendar.displayCalendarMonth(12);					// the number of remaining spots changed
		System.out.println("/ Full Calendar after 3 bookings for yoga and 1 booking for boxing /");
		System.out.println("");
		
		System.out.println("/ u0 Calendar /");
		u0.displayCalendar();									//u0 and u1 wants to see their personal calendars
		System.out.println("/ u0 Calendar /");
		System.out.println("");
		
		System.out.println("/ u1 Calendar /");
		u1.displayCalendar();
		System.out.println("/ u1 Calendar /");
		System.out.println("");
		
		System.out.println("u3 tries to book the christmas yoga");
		u3.bookActivity(0);												//trying to book a full activity
		System.out.println("");
		
		System.out.println("u2 doesn't want to do yoga anymore");
		u2.cancelReservation(0);;										//cancelling yoga reservation
		System.out.println("");
		
		System.out.println("u3 tries again to book the christmas yoga");
		u3.bookActivity(0);												//trying to book a full activity
		System.out.println("");
		
		System.out.println("/ u2 Calendar /");
		u2.displayCalendar();									//u2 and u3 wants to see their personal calendars
		System.out.println("/ u2 Calendar /");
		System.out.println("");
		
		System.out.println("/ u3 Calendar /");
		u3.displayCalendar();
		System.out.println("/ u3 Calendar /");
		System.out.println("");
		
		//TRAINER TESTS		---------------------------------------------------------------------------------------------------------------
		
		System.out.println("/ t0 Calendar /");
		t0.displayCalendar();									//t0 and t1 print their personal calendars
		System.out.println("/ t0 Calendar /");
		System.out.println("");
		
		System.out.println("/ t1 Calendar /");
		t1.displayCalendar();
		System.out.println("/ t1 Calendar /");
		System.out.println("");
		
		t0.printParticipationList(0);
		System.out.println("");
		
		System.out.println("t0 deletes activity christmas Yoga");
		t0.deleteActivity(0);
		System.out.println("");
		
		System.out.println("/ Full Calendar after christmas yoga had been deleted /");
		FullCalendar.displayCalendarMonth(12);									
		System.out.println("/ Full Calendar after christmas yoga had been deleted /");
		System.out.println("");
		
		System.out.println("/ u3 Calendar after christmas yoga had been deleted /");
		u3.displayCalendar();								
		System.out.println("/ u3 Calendar after christmas yoga had been deleted /");
		System.out.println("");
		
		
		
		
		
		
	}
}
