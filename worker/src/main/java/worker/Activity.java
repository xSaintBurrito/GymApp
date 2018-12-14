package worker;

/**
 * Defines the concept of Activity.
 * @author Pedro Fonseca & Lázaro Amor
 *
 */
public class Activity {

	/**
	 * Holds the name of the Activity.
	 */
	private String name;
	
	/**
	 * Constructor for new instances of Activity.
	 * @param name
	 */
	public Activity (String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the Activity.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Activity's denomination in a String.
	 * @return name
	 */
	public String toString() {
		return this.name;
	}
}
