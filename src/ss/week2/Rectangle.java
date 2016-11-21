package ss.week2;

public class Rectangle {
    private /*@ spec_public @*/ int length;
    private /*@ spec_public @*/ int width;

    /**
     * Create a new Rectangle with the specified length and width.
     */    
    //@ ensures length >= 0;
    //@ ensures width >= 0;
    //@ assignable this.length;
    //@ assignable this.width;
    //@ ensures this.length == length;
    //@ ensures this.width == width;
    public Rectangle(int length, int width) {
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ pure
    public int length() {
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ pure
    public int width() {
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ requires width >= 0 && length >= 0;
    //@ pure
    public int area() {
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ requires width >= 0 && length >= 0;
    //@ pure
    public int perimeter() {
    	return width * 2 + length * 2;
    }
}
