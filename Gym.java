package worker;

/**
 * Represents the entity Gym.
 * @author Pedro Fonseca & Lázaro Amor
 *
 */

public class Gym {

	/**
	 * Holds the name of the Gym.
	 */
	private String name;
	
	/**
	 * Creates Gym objects.
	 * @param Receives as a parameter the name of the Gym to create.
	 */
	public Gym (String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the Gym.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns a String with the Gym's name.
	 * @return Gym name String
	 */
	public String toString() {
		return this.name;
	}
	
}
