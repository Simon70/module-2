package ss.week6;

import java.util.Scanner;

public class Hello {

    public Hello() {

    }

    public static void main(String[] args) {
		System.out.println("What is your name?");

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String name = scanner.next();
            if (name.isEmpty()) {
                break;
			}
			System.out.println("Hello " + name);
		}
	}

}
