package worker;

import java.util.ArrayList;

/**
 * Represents the entity Worker.
 * @author Pedro Fonseca & Lázaro Amor
 *
 */
public class Worker {

	/**
	 * Holds the name of the Worker.
	 */
	private String name;
	
	/**
	 * Holds the list of Reports the Worker has access to.
	 */
	private ArrayList<Report> reportsFollowed;
	
	/**
	 * Holds the list of important Reports for the Worker.
	 */
	private ArrayList<Report> importantReports;
	
	/**
	 * Constructor for new Worker objects.
	 * Initializes the reports and the important reports lists as an empty ArrayList.
	 * @param name
	 */
	public Worker (String name) {
		this.name = name;
		this.reportsFollowed = new ArrayList<>();
		this.importantReports = new ArrayList<>();
	}
	
	/**
	 * Returns the name of the Worker.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the list of followed Reports.
	 * @return reportsFollowed
	 */
	public ArrayList<Report> getReportsFollowed() {
		return reportsFollowed;
	}

	/**
	 * Returns the list of the important Reports.
	 * @return importantReports
	 */
	public ArrayList<Report> getImportantReports() {
		return importantReports;
	}

	/**
	 * Marks the Report to be followed or unfollowed.
	 * @param r
	 */
	public void changeFollowStatus(Report r) {
		if (!reportsFollowed.contains(r)) {
			reportsFollowed.add(r);
		} else reportsFollowed.remove(r);
	}
	
	/**
	 * Marks the Report as important or unmarks it if it is marked.
	 * @param r
	 */
	public void changeImportantStatus(Report r) {
		if(!importantReports.contains(r)) {
			importantReports.add(r);
		} else importantReports.remove(r);
	}
	
	/**
	 * Provides to the Worker access to the Calendar page with the Reports he has access to.
	 */
	public void accessCalendar() {
		//redirect to Calendar page
			//in this page he will have displayed their own schedules.
	}
	
	/**
	 * The graphical interface will present the Worker with the important Reports and their informations.
	 */
	public void getImportantReportStatus() { //should return ArrayList<Report> ???
		for (Report r : importantReports) {
			r.toString();
		}
	}
	
}
