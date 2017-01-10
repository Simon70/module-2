package ss.week7.threads;

/**
 * Created by simon on 09.01.17.
 */
public class TextConsole extends Thread {

    public TextConsole(String name) {
        super(name);
    }

    public static void main(String[] args) {
        new TextConsole("Thread A").start();
        new TextConsole("Thread B").start();
    }

    @Override
    public void run() {
        sum();
    }

    private void sum() {
        int first = SynConsole.readInt(this.getName() + ": " + "Number one: ", "A Number pls");
        int second = SynConsole.readInt(this.getName() + ": " + "Number two: ", "A Number pls");
        SynConsole.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
    }
}
