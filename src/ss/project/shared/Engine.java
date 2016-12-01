package ss.project.shared;

public class Engine {

	private World		world;
	private Player[]	players;

	/**
	 * True while the game is running.
	 */
	private boolean		gameRunning;

	/**
	 * Create a new world and create players.
	 *
	 * @param worldSize
	 * @param playerAmount
	 * @param aiAmount
	 */
	public Engine(Vector3 worldSize, int playerAmount, int aiAmount) {
		this.world = new World(worldSize);
		createPlayers(playerAmount, aiAmount);
		startGame();
	}

	/**
	 * Create x new players and name them.
	 *
	 * @param amount
	 *            the amount of new players to generate.
	 * @param aiAmount
	 *            the amount of players that should be controlled by a computer.
	 */
	private void createPlayers(int amount, int aiAmount) {
		int remainingAI = aiAmount;
		players = new Player[amount];
		for (int i = 0; i < amount; i++) {
			boolean isAI = false;
			if (remainingAI > 0) {
				remainingAI--;
				isAI = true;
			}

			//Create new players with name: Player1
			players[i] = new Player(this, "Player " + i, isAI);
		}
	}

	/**
	 * @return world of this game.
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * returns the player if within range.
	 *
	 * @param id
	 *            Index number of the player.
	 * @return Null if ID not in range, else the player object.
	 */
	public Player getPlayer(int id) {
		if (id < players.length && id >= 0) {
			return players[id];
		}
		return null;
	}

	/**
	 * 
	 * @return the amount of current players, both AI and real.
	 */
	public int getPlayerCount() {
		return players.length;
	}
	
	/**
	 * Start the game and make every player do turns.
	 */
	private void startGame() {
		gameRunning = true;
		
		int turns = 0;

		//By default start with player 0.
		int currentPlayer = 0;

		//Don't start the game if there are no players.
		if (getPlayerCount() <= 0) {
			return;
		}

		while (gameRunning) {
			getPlayer(currentPlayer).doTurn();

			currentPlayer++;
			if (currentPlayer >= getPlayerCount()) {
				currentPlayer = 0;
			}

			//TODO: make the game end when someone wins.
			turns++;
			if (turns > 10) {
				System.out.println(turns);
				return;
			}
		}
	}
}
