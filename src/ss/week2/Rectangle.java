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
    	assert length >= 0 : "length should be bigger or equal to zero.";
    	assert width >= 0 : "width should be bigger or equal to zero.";
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ ensures \result > 0;
    //@ pure
    public int length() {
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result > 0;
    //@ pure
    public int width() {
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ requires width >= 0 && length >= 0;
    //@ ensures \result == length() * width();
    //@ pure
    public int area() {
    	assert length >= 0 : "length should be bigger or equal to zero.";
    	assert width >= 0 : "width should be bigger or equal to zero.";
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ requires width >= 0 && length >= 0;
    //@ ensures \result == width() * 2 + length() * 2;
    //@ pure
    public int perimeter() {
    	assert length >= 0 : "length should be bigger or equal to zero.";
    	assert width >= 0 : "width should be bigger or equal to zero.";
    	return width * 2 + length * 2;
    }
}
