package ss.project;

public class WorldPosition {

	private Vector3 coordinates;

	/**
	 * Create a new worldPosition object with specified coordinates.
	 * 
	 * @param coordinates
	 */
	public WorldPosition(Vector3 coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * 
	 * @return coordinates of this Position.
	 */
	public Vector3 getCoordinates() {
		return coordinates;
	}
}
