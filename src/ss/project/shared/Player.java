package ss.project.shared;

import ss.project.shared.AI.*;

public class Player {

	private Engine					engine;
	private String					name;
	private boolean					hasAI;
	private IArtificialIntelligence	ai;

	/**
	 * Create a new player object with specified name.
	 * 
	 * @param name
	 *            name of the new player.
	 */
	public Player(Engine engine, String name, boolean ai) {
		this.engine = engine;
		this.name = name;
		this.hasAI = ai;

		if (this.hasAI) {
			//Assign an AI.
			this.ai = new AiRandom();
			this.ai.initialize(this);
		}
	}

	/**
	 * 
	 * @return True if this player is controlled by the computer.
	 */
	public boolean isHasAI() {
		return hasAI;
	}

	/**
	 * Called everytime a new turn should be done. TODO: add the possibility for
	 * the user to do a turn, now it's just AI.
	 */
	public void doTurn() {
		if (this.hasAI) {
			//The user is an AI, make the AI do a turn.
			this.ai.doTurn(engine.getWorld());
		} else {
			//The user can select a place to build.
			return;
		}
	}
	
	public String getName() {
		return name;
	}
}
