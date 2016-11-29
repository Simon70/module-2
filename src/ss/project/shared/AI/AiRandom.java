package ss.project.shared.AI;

import ss.project.shared.*;

public class AiRandom implements IArtificialIntelligence {

	private Player player;

	@Override
	public void initialize(Player player) {
		System.out.println("Initialize");
		this.player = player;
	}

	@Override
	public void doTurn(World world) {
		System.out.println("Do a turn");

		setNewGameItem(world);
	}

	private void setNewGameItem(World world) {
		for (int x = 0; x < world.getSize().getX(); x++) {
			for (int y = 0; y < world.getSize().getY(); y++) {
				for (int z = 0; z < world.getSize().getZ(); z++) {
					if (world.addGameItem(new Vector3(x, y, z), player)) {
						return;
					}
				}
			}
		}
	}

	@Override
	public void end() {
		System.out.println("End");
	}

}
