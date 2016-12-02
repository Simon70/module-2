package ss.project.shared.AI;

import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

import ss.project.shared.*;

public class AiRandom implements IArtificialIntelligence {

	private Player player;

	@Override
	//TODO: call initialize before the game starts.
	public void initialize(Player player) {
		System.out.println("Initialize");
		this.player = player;
	}

	@Override
	public void doTurn(World world) {
		setNewGameItem(world);
	}

	private void setNewGameItem(World world) {
		while(true) {
			int x = ThreadLocalRandom.current().nextInt(0,world.getSize().getX());
			int y = ThreadLocalRandom.current().nextInt(0,world.getSize().getY());
			
			if (world.addGameItem(new Vector2(x, y), player)) {
				return;
			}
		}
	}

	@Override
	public void end() {
		System.out.println("End");
	}

}
