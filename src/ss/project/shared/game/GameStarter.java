package ss.project.shared;

import com.sun.j3d.utils.applet.MainFrame;

import ss.project.client.ui.WorldViewer;

/**
 * Creates a game and has the main function.
 * 
 * @author fw
 *
 */
public class GameStarter {

	private static UIController uiController;

	public static void main(String[] args) {
		//Create a controller for the UI.
		uiController = new UIController();

		//Create a new game with world size 4,4,4 and 2 players
		new Engine(new Vector3(4, 4, 4), 2, 2);
	}
}
