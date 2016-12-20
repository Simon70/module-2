package ss.week6;

import java.util.Scanner;

public class Words {

	public Words() {

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNextLine()) {
			String sentence = scanner.nextLine();
			
			Scanner wordReader = new Scanner(sentence);
			int counter = 0;
			while(wordReader.hasNext()) {
				String word = wordReader.next();
				System.out.println("Word "+counter+": "+word);
			}
		}
	}
}
