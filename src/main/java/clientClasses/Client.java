package clientClasses;

/**
 * Represents the entity Client.
 * @author Pedro Fonseca & L�zaro Amor
 *
 */

public class Client {

	private int userId;

	/**
	 * Holds the name of the Client as a String.
	 */
	private String name;
	
	/**
	 * Constructor of the new Clients.
	 * @param name
	 */
	public Client (String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the Client.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Client's name in a String.
	 * @return name
	 */
	public String toString() {
		return this.name;
	}

	public int getUserId() {
		return this.userId;
	}
}
