package ss.project.shared;

public class Player {

	private String	name;
	private boolean	hasAI;
	private IArtificialIntelligence ai;

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

	/**
	 * 
	 * @return True if this player is controlled by the computer.
	 */
	public boolean isHasAI() {
		return hasAI;
	}
}
