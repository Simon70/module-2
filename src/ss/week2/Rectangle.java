package ss.week2;

public class Rectangle {
	private /* @ spec_public@ */ int length;
	private /* @ spec_public@ */ int width;

	/**
	 * Create a new Rectangle with the specified length and width.
	 */
	// @ ensures length >= 0;
	// @ ensures width >= 0;
	// @ assignable this.length;
	// @ assignable this.width;
	public Rectangle(int length, int width) {
	}

	/**
	 * The length of this Rectangle.
	 */
	public int length() {
		return 0;
	}

	/**
	 * The width of this Rectangle.
	 */
	public int width() {
		return 0;
	}

	/**
	 * The area of this Rectangle.
	 */
	public int area() {
		return 0;
	}

	/**
	 * The perimeter of this Rectangle.
	 */
	public int perimeter() {
		return 0;
	}
}
