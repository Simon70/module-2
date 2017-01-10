package ss.week7.threads;

/**
 * Created by simon on 09.01.17.
 */
public class TextSyncConsole extends Thread {

    private static Object lock = new Object();

    public TextSyncConsole(String name) {
        super(name);
    }

    public static void main(String[] args) {
        new TextSyncConsole("Thread A").start();
        new TextSyncConsole("Thread B").start();
    }

    @Override
    public void run() {
        sum();
    }

    private void sum() {
        synchronized (lock) {
            int first = Console.readInt(this.getName() + ": " + "Number one: ", "A Number pls");
            int second = Console.readInt(this.getName() + ": " + "Number two: ", "A Number pls");
            Console.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
        }
    }
}
