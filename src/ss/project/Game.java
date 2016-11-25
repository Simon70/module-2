package ss.project;

public class Game {

    private World world;
    private Player[] players;

    /**
     * Create a new world and create players.
     *
     * @param worldSize
     * @param playerAmount
     * @param aiAmount
     */
    public Game(Vector3 worldSize, int playerAmount, int aiAmount) {
        this.world = new World(worldSize);
        createPlayers(playerAmount, aiAmount);
    }

    /**
     * Create x new players and name them.
     *
     * @param amount   the amount of new players to generate.
     * @param aiAmount the amount of players that should be controlled by a computer.
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
            players[i] = new Player("Player " + i, isAI);
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
     * @param id Index number of the player.
     * @return Null if ID not in range, else the player object.
     */
    public Player getPlayer(int id) {
        if (id < players.length && id >= 0) {
            return players[id];
        }
        return null;
    }
}
