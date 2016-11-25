package ss.project;

public class Player {

	private String	name;
	private boolean	hasAI;
	private AI		ai;

	/**
	 * Create a new player object with specified name.
	 * 
	 * @param name
	 *            name of the new player.
	 */
	public Player(String name, boolean ai) {
		this.name = name;
		this.hasAI = ai;

		if (this.hasAI) {
			//Assign an AI.
		}
	}

}