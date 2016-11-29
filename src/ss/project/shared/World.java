package ss.project.shared;

public class World {


	private Vector3				size;
	private WorldPosition[][][]	worldPosition;

	/**
	 * Create a new world object, set the size and initialize it.
	 * 
	 * @param size
	 *            A vector3 containing width,height and length.
	 */
	public World(Vector3 size) {
		this.size = size;
		initializeWorld(this.size);
	}

	/**
	 * Initialize the world by creating worldPosition objects.
	 */
	private void initializeWorld(Vector3 worldSize) {
		worldPosition = new WorldPosition[worldSize.getX()][worldSize.getY()][worldSize.getZ()];

		for (int x = 0; x < worldSize.getX(); x++) {
			for (int y = 0; y < worldSize.getY(); y++) {
				for (int z = 0; z < worldSize.getZ(); z++) {
					worldPosition[x][y][z] = new WorldPosition(new Vector3(x, y, z));
				}
			}
		}
	}

	/**
	 * Get the size of this world.
	 * 
	 * @return the size of this world.
	 */
	public Vector3 getSize() {
		return size;
	}

	/**
	 * 
	 * @param coordinates
	 *            coordinates of the WorldPosition we want to know.
	 * @return WorldPosition at specified coordinates. Returns null if
	 *         coordinates are outside range.
	 */
	public WorldPosition getWorldPosition(Vector3 coordinates) {
		if (!insideWorld(coordinates)) {
			return null;
		}
		return worldPosition[coordinates.getX()][coordinates.getY()][coordinates.getZ()];
	}

	/**
	 * 
	 * @param coordinates
	 * @return True if the coordinates are inside the world range.
	 */
	public boolean insideWorld(Vector3 coordinates) {
		if (coordinates.getX() >= 0 && coordinates.getY() >= 0 && coordinates.getZ() >= 0 &&
				coordinates.getX() < getSize().getX() && coordinates.getY() < getSize().getY() &&
				coordinates.getZ() < getSize().getZ()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Create and set a new GameItem in this world with specified owner.
	 * 
	 * @param coordinates
	 *            Coordinates where the GameItem should be placed.
	 * @param owner
	 *            The owner of the GameItem.
	 * @return False if this move is not possible, true if possible.
	 */
	public boolean addGameItem(Vector3 coordinates, Player owner) {
		WorldPosition wp = getWorldPosition(coordinates);
		if (wp != null) {
			if (wp.hasGameItem()) {
				return false;
			} else {
				wp.setGameItem(owner);
				return true;
			}
		} else {
			return false;
		}
	}
}
