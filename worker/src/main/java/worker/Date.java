package worker;

/**
 * Defines the concept of Date.
 * @author Pedro Fonseca & Lázaro Amor
 *
 */

public class Date {

	/**
	 * Holds the date in the dd/mm/aaaa format as a String.
	 */
	private String date;
	
	/**
	 * The Strings day, month and year hold the 3 elements of a date separately.
	 */
	private String day, month, year;
	
	/**
	 * Contructor for a Date.
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(String day, String month, String year) {
		this.date = day + "/" + month + "/" + year;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * Returns the day of the Date.
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * Returns the month of the Date.
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * Returns the year of the Date.
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Returns the full date in the predefined format.
	 * @return date
	 */
	public String toString() {
		return date;
	}
	
}
