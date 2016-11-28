package ss.project.shared;

public class Vector3 {

	private final int	x;
	private final int	y;
	private final int	z;

	/**
	 * Create a Vector3 with x, y, z.
	 * 
	 * @param x
	 *            the x coordinate.
	 * @param y
	 *            the y coordinate.
	 * @param z
	 *            the z coordinate.
	 */
	public Vector3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * 
	 * @return the x coordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return the y coordinate.
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return the z coordinate.
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Easy way of writing vector3(1,1,1).
	 * 
	 * @return a standard vector3(1,1,1).
	 */
	public static Vector3 One() {
		return new Vector3(1, 1, 1);
	}
}
