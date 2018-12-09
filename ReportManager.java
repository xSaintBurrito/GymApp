package worker;

import java.util.ArrayList;

/**
 * Class that manages all the Reports.
 * @author Pedro Fonseca & Lázaro Amor
 *
 */

public class ReportManager {
	
	private static ArrayList<Report> reports = new ArrayList<>();
	
	private static ReportManager rm = null;
	
	/**
	 * Private ReportManager() constructor so that we can apply the Singleton pattern.
	 * This is because we only need one instance of the ReportManager.
	 */
	private ReportManager() {}
	
	/**
	 * Implements the Singleton pattern with lazy initialization.
	 * @return The instance of the ReportManager. If it has not been created yet, this method calls the constructor and returns the new instance.
	 */
	public ReportManager getReportManagerInstance() {
		if (rm.equals(null)) {
			return new ReportManager();
		}
		else return rm;
	}
	
	/**
	 * Returns all the reports the worker has access to.
	 * @return All reports this worker can access.
	 */
	public ArrayList<Report> getAllGymsReports() {
		return reports;
	}
	
	/**
	 * Returns reports of work-outs filtered with some specifications.
	 * Filters by gym, date, client and activity.
	 * 
	 * Usage: search only reports from gymX -> getFilteredReports(gymX,null, null, null)
	 *        search only reports from a specific date and also a specific client -> getFilteredReports(null, date, client, null)
	 *        
	 * @return All the reports that correspond to the filters passed as parameters.
	 */
	public ArrayList<Report> getFilteredReports (Gym gym, Date date, Client client, Activity activity) {
		ArrayList<Report> filtered = reports;
		
		for (Report r : reports) {
			if ((!gym.equals(null) && !gym.equals(r.getGym())) || (!date.equals(null) && !date.equals(r.getDate())) 
					|| (!client.equals(null) && !client.equals(r.getClient())) || (!activity.equals(null) && !activity.equals(r.getActivity())))
				filtered.remove(r);
		}
		
		return filtered;
	}
	
	/**
	 * Changes the importance of the Reports.
	 * This is completed by removing or adding to the importantReports list of the Worker.
	 * @param report
	 */
	public void changeImportanceStatus(Worker w, Report r) {
		w.changeImportantStatus(r);
	}
	
	/**
	 * Makes the worker follow or unfollow a specific Report.
	 * This is completed by removing or adding to the reportsFollowed list of the Worker
	 */
	public void changeFollowStatus(Worker w, Report r) {
		w.changeFollowStatus(r);
	}
}




