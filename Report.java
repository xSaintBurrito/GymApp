package worker;

/**
 * Defines the concept of Report
 * @author Pedro Fonseca & Lázaro Amor
 *
 */
public class Report {

	/**
	 * Holds the Client of the Report.
	 */
	private Client client;
	
	/**
	 * Holds the Date of the Report.
	 */
	private Date date;
	
	/**
	 * Holds the Gym of the Report.
	 */
	private Gym gym;
	
	/**
	 * Holds the Activity of the Report.
	 */
	private Activity activity;
	
	/**
	 * Holds the mark attributed to the Activity the Client practiced in the Report.
	 */
	private int mark;	
	
	/**
	 * Constructor for new Reports.
	 * @param c
	 * @param d
	 * @param g
	 * @param act
	 * @param mark
	 */
	public Report(Client c, Date d, Gym g, Activity act, int mark) {
		this.client = c;
		this.date = d;
		this.gym = g;
		this.activity = act;
		this.mark = mark;
	}

	/**
	 * Returns the Client of the Report.
	 * @return
	 */
	public Client getClient() {
		return client;
	}
	
	/**
	 * Returns the Date of the exercise in the Report.
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the Gym where the exercise took place.
	 * @return gym
	 */
	public Gym getGym() {
		return gym;
	}

	/**
	 * Returns the Activity exercised of the Report.
	 * @return
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * Returns the attributed mark of the Report.
	 * @return mark
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * Attributes a mark to the work-out.
	 * @param mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	/**
	 * Joins in a String every important piece of information about the Report.
	 * @return Information String
	 */
	public String toString() {
		return "\nClient: " + this.client.toString() + "\nDate: " + this.date.toString() + "\nGym: " + this.gym.toString() + "\n"
				+ "Activity: " + this.activity.toString() + "\nMark: " + this.mark;
	}
	
}
