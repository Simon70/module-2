package ss.project.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.project.*;

public class GameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test4x4x4() {
		//Create a new game with size 4, 0 players of which 0 AI.
		game = new Game(new Vector3(4, 4, 4), 0, 0);

		assertNotNull("World should not be created.", game.getWorld());

		//Check inside range.
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int z = 0; z < 4; z++) {
					assertTrue(String.format("Vector({0},{1},{2}) should be inside range.", x, y, z),
						game.getWorld().insideWorld(new Vector3(x, y, z)));
				}
			}
		}

		//Check outside range.
		assertFalse("Vector(-1,0,0) should be outside range", game.getWorld().insideWorld(new Vector3(-1, 0, 0)));
		assertFalse("Vector(0,-1,0) should be outside range", game.getWorld().insideWorld(new Vector3(0, -1, 0)));
		assertFalse("Vector(0,0,-1) should be outside range", game.getWorld().insideWorld(new Vector3(0, 0, -1)));

		assertFalse("Vector(4,0,0) should be outside range", game.getWorld().insideWorld(new Vector3(4, 0, 0)));
		assertFalse("Vector(0,4,0) should be outside range", game.getWorld().insideWorld(new Vector3(0, 4, 0)));
		assertFalse("Vector(0,0,4) should be outside range", game.getWorld().insideWorld(new Vector3(0, 0, 4)));
	}

	@Test
	public void testPlayers() {
		//Create 2 players of which 0 AI.
		game = new Game(new Vector3(4, 4, 4), 2, 0);

		assertNotNull("Player 0 should be created. ", game.getPlayer(0));
		assertNotNull("Player 0 should be created. ", game.getPlayer(1));

		assertNull("Player 2 should not be created. ", game.getPlayer(2));
	}

}
