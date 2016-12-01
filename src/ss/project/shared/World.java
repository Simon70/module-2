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
	 *            coordinates of the z axis we want to get.
	 * @return WorldPosition at the first empty WorldPosition at x and y.
	 *         Returns null if coordinates are outside range or if no empty spot
	 *         has been found.
	 */
	public WorldPosition getWorldPosition(Vector2 coordinates) {
		if (!insideWorld(new Vector3(coordinates))) {
			return null;
		}

		//get the highest possible worldposition.
		for (int z = 0; z < size.getZ(); z++) {
			WorldPosition wp = worldPosition[coordinates.getX()][coordinates.getY()][z];
			if (wp != null) {
				return wp;
			}
		}
		//No position possible
		return null;
	}

	/**
	 * 
	 * @param coordinates
	 * @param player
	 * @return
	 */
	public boolean isOwner(Vector3 coordinates, Player player) {
		WorldPosition worldPos = getWorldPosition(coordinates);
		if (worldPos != null) {
			return worldPos.isOwner(player);
		}
		return false;
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

	/**
	 * Create and set a new GameItem in this world with specified owner.
	 * 
	 * @param coordinates
	 *            Coordinates where the GameItem should be placed.
	 * @param owner
	 *            The owner of the GameItem.
	 * @return False if this move is not possible, true if possible.
	 */
	public boolean addGameItem(Vector2 coordinates, Player owner) {
		WorldPosition wp = getWorldPosition(coordinates);
		if (wp != null) {
			if (wp.hasGameItem()) {
				return false;
			} else {
				//Set the item to this owner.
				wp.setGameItem(owner);
				//Check whether we have 4 on a row.

				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param newCoordinates
	 */
	private void checkWin(Vector3 newCoordinates, Player player) {
		for (int x = newCoordinates.getX() - 1; x < 2; x++) {
			for (int y = newCoordinates.getY() - 1; y < 2; y++) {
				for (int z = newCoordinates.getZ() - 1; z < 2; z++) {
					Vector3 vector = new Vector3(x, y, z);
					//Don't check zero, because that's ourself.
					if (!vector.equals(Vector3.ZERO)) {
						if (isOwner(newCoordinates, player)) {
							//We found a neighboar that is owner by us as well! Continue this path.
							
						}
					}
				}
			}
		}
	}
	
	private boolean checkWin(Vector3 coordinates, Player player, Vector3 direction, int count) {
		//if(coordinates)
		return false;
	}
}
