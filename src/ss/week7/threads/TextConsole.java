package ss.week7.threads;

/**
 * Created by simon on 09.01.17.
 */
public class TextConsole extends Thread {
    public TextConsole(String name) {
        super(name);
    }

    @Override
    public void run() {
        sum();
    }

    private void sum() {
        int first = Console.readInt("Number one: ", "A Number pls");
        int second = Console.readInt("Number two: ", "A Number pls");
        Console.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
    }
}
