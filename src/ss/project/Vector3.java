package ss.project;

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
	 * Easy way of writing Vector3(1,1,1). TODO: Don't create a new instance,
	 * but instead refer to an existing Vector.
	 * 
	 * @return a standard Vector3(1,1,1).
	 */
	public static Vector3 One() {
		return new Vector3(1, 1, 1);
	}

	/**
	 * Easy way of writing Vector3(0,0,0). TODO: Don't create a new instance,
	 * but instead refer to an existing Vector.
	 * 
	 * @return a standard Vector3(0,0,0).
	 */
	public static Vector3 Zero() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Vector3 other = (Vector3) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		if (z != other.z) {
			return false;
		}
		return true;
	}
}
