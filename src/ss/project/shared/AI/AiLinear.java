package ss.project.shared.AI;

import ss.project.shared.*;

public class AiLinear implements IArtificialIntelligence {

	private Player player;

	@Override
	//TODO: call initialize before the game starts.
	public void initialize(Player player) {
		System.out.println("Initialize");
		this.player = player;
	}

	@Override
	public void doTurn(World world) {
		//System.out.println("Do a turn");

		setNewGameItem(world);
	}

	private void setNewGameItem(World world) {
		for (int x = 0; x < world.getSize().getX(); x++) {
			for (int y = 0; y < world.getSize().getY(); y++) {
				if (world.addGameItem(new Vector2(x, y), player)) {
					return;
				}
			}
		}
	}

	@Override
	public void end() {
		System.out.println("End");
	}

}
