package ss.week6;

import java.util.Scanner;

/**
 * Created by simon on 20.12.16.
 */
public class Util {
    private static Scanner scanner;

    private static void checkScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static String getNextLine() {
        checkScanner();
        return scanner.nextLine();
    }

    public static String getNextLine(String question) {
        checkScanner();
        System.out.println(question);
        return scanner.nextLine();
    }

}
