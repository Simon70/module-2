package ss.week6;

import java.util.Scanner;

public class Hello {

    public Hello() {

    }

    public static void main(String[] args) {
		System.out.println("What is your name?");

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String name = scanner.nextLine();
			if(name.isEmpty()) {
				break;
			}
			System.out.println("Hello " + name);
		}
		System.out.println("seeya");
	}

}
