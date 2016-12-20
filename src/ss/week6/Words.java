package ss.week6;

import java.util.Scanner;

public class Words {

	public Words() {

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Line (or \"end\"): ");

		while (scanner.hasNextLine()) {
			String sentence = scanner.nextLine();

			Scanner wordReader = new Scanner(sentence);
			int counter = 0;
			while (wordReader.hasNext()) {
				String word = wordReader.next();
				if (counter == 0 && word.equals("end")) {
					scanner.close();
					wordReader.close();
					return;
				}
				
				counter++;
				System.out.println("Word " + counter + ": " + word);
			}
			wordReader.close();
			System.out.print("Line (or \"end\"): ");
		}
		scanner.close();
	}
}
