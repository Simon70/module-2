package ss.week6.voteMachine;


import ss.week6.Util;

import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * Created by simon on 20.12.16.
 */
public class VoteTUIView implements VoteView {
    private final VoteMachine vm;

    public VoteTUIView(VoteMachine vm) {
        this.vm = vm;
    }

    @Override
    public void start() {
        while (true) {
            String input = Util.getNextLine();
            String[] args = input.split(" ");

            switch (args[0].toLowerCase()) {
                case "vote":
                    if (args.length == 2) {
                        vm.vote(args[1]);
                        System.out.println("Vote registered!");
                        break;
                    }
                    showHelp();
                    break;
                case "add":
                    if (args.length == 3 && args[1].equalsIgnoreCase("party")) {
                        vm.addParty(args[2]);
                        break;
                    }
                    showHelp();
                    break;
                case "votes":
                    System.out.println(vm.getVotes());
                    break;
                case "parties":
                    System.out.println(vm.getParties());
                    break;
                case "exit":
                    return;
                case "help":
                default:
                    showHelp();
                    break;
            }
        }
    }

    private void showHelp() {
        System.out.print("Commands:\n" +
                                 "\tvote [party]\n" +
                                 "\tadd party [party]\n" +
                                 "\tvotes\n" +
                                 "\tparties\n" +
                                 "\texit\n" +
                                 "\thelp\n");
    }

    @Override
    public void showVotes(Map<String, Integer> votes) {
        System.out.println(votes);
    }

    @Override
    public void showParties(List<String> parties) {
        System.out.println(parties);
    }

    @Override
    public void showError(String message) {
        System.err.println(message);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
