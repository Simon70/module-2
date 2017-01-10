package ss.week7.threads;

/**
 * Incorrect communication between IntProducer en IntConsumer.
 */
public class SynchronizedIntCell implements IntCell {
    private int value = 0;

    public synchronized int getValue() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            return value;
        }
        return value;
    }

    public synchronized void setValue(int valueArg) {
        this.value = valueArg;
        this.notifyAll();
    }
}

/* ********************************************************************** *
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 * ********************************************************************** */
