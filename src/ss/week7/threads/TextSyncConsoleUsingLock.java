package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by simon on 09.01.17.
 */
public class TextSyncConsoleUsingLock extends Thread {

    private static ReentrantLock lock = new ReentrantLock();

    public TextSyncConsoleUsingLock(String name) {
        super(name);
    }

    public static void main(String[] args) {
        new TextSyncConsoleUsingLock("Thread A").start();
        new TextSyncConsoleUsingLock("Thread B").start();
    }

    @Override
    public void run() {
        sum();
    }

    private void sum() {
        lock.lock();
        int first = Console.readInt(this.getName() + ": " + "Number one: ", "A Number pls");
        int second = Console.readInt(this.getName() + ": " + "Number two: ", "A Number pls");
        Console.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
        lock.unlock();
    }
}
