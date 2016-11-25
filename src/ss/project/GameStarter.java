package ss.project;

/**
 * Creates a game and has the main function.
 * 
 * @author fw
 *
 */
public class GameStarter {

	public static void main(String[] args) {
		//Create a new game with world size 4,4,4 and 2 players
		Game game = new Game(new Vector3(4, 4, 4), 2, 2);
	}
}
