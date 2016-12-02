package ss.project.shared;

public class WorldPosition {

	private final Vector3	coordinates;
	private GameItem		gameItem;

	/**
	 * Create a new worldPosition object with specified coordinates.
	 * 
	 * @param coordinates
	 */
	public WorldPosition(Vector3 coordinates) {
		this.coordinates = coordinates;
		this.gameItem = null;
	}

	/**
	 * 
	 * @return coordinates of this Position.
	 */
	public Vector3 getCoordinates() {
		return coordinates;
	}

	public GameItem getGameItem() {
		return gameItem;
	}

	/**
	 * Set the gameItem of this worldposition with the specified owner, will
	 * create a new one.
	 *
	 * @param owner
	 *            owner of the new GameItem.
	 */
	public void setGameItem(Player owner) {
		this.gameItem = new GameItem(owner);
	}

	/**
	 * @return True if this position has a gameitem, false if not.
	 */
	public boolean hasGameItem() {
		return getGameItem() != null;
	}

	public boolean isOwner(Player player) {
		if (hasGameItem()) {
			if(getGameItem().getOwner()==null) {
				System.out.println("null");
			}
			return getGameItem().getOwner().equals(player);
		}
		return false;
	}
}
