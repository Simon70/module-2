package ss.week6.voteMachine;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {

	private VoteMachine voteMachine;

	public VoteTUIView(VoteMachine voteMachine) {
		this.voteMachine = voteMachine;
	}

	public void start() {
		System.out.println("Do something plz");

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			input = input.toLowerCase();
			String[] cmd = input.split(" ");

			if (cmd != null && cmd.length > 0) {
				String cmd1 = cmd[0];

				switch (cmd1) {
					case "":
						System.out.println("Please enter something :)))");
						break;
					case "vote":
						if (cmd.length > 1) {
							voteMachine.vote(cmd[1]);
						} else {
							System.out.println("Wrong arguments.");
						}
						break;
					case "add":
						if (cmd.length > 2) {
							voteMachine.addParty(cmd[2]);
						} else {
							System.out.println("Wrong arguments.");
						}
						break;
					case "votes":
						System.out.println(voteMachine.getVotes());
						break;
					case "parties":
						System.out.println(voteMachine.getParties());
						break;
					case "exit":
						System.exit(0);
						break;
					case "help":
						System.out.println(
							"VOTE [PARTY] \n ADD PARTY [party]\n VOTES \n PARTIES \n EXIT \n HELP");
						break;
					default:
						System.out.println("Uknown argument.");
						break;
				}
			}

		}
		scanner.close();
		System.out.println("seeya");
	}

	public void showVotes(Map<String, Integer> votes) {
		StringBuilder result = new StringBuilder();

		for (Entry<String, Integer> entrySet : votes.entrySet()) {
			result.append(entrySet.getKey());
			result.append(" has ");
			result.append(entrySet.getValue());
			result.append(" votes.");
			result.append("\n");
		}

		System.out.print(result.toString());
	}

	public void showParties(List<String> parties) {
		StringBuilder result = new StringBuilder();
		Iterator<String> partyIterator = parties.iterator();

		while (partyIterator.hasNext()) {
			result.append(partyIterator.next());
			result.append("\n");
		}

		System.out.print(result.toString());
	}

	public void showError(String error) {
		System.out.println(error);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		switch ((String) arg1) {
			case "party":
				System.out.println("added a party.");
				break;

			case "vote":
				System.out.println("added a vote.");
				break;
			default:
				break;
		}
	}
}
