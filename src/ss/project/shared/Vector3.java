package ss.project.shared;

public class Vector3 {

    /**
     * Easy way of writing Vector3(1,1,1).
     * but instead refer to an existing Vector.
     */
    public static final Vector3 ONE = new Vector3(1, 1, 1);


    /**
     * Easy way of writing Vector3(0,0,0).
     * but instead refer to an existing Vector.
     */
    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    private final int x;
    private final int y;
    private final int z;

    /**
     * Create a Vector3 with x, y, z.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @param z the z coordinate.
     */
    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * @return the z coordinate.
     */
    public int getZ() {
        return z;
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
