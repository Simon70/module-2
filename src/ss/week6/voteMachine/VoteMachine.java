package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

import java.util.List;
import java.util.Map;

public class VoteMachine {

    private VoteView voteTUIView;
    private PartyList partyList;
    private VoteList voteList;

    public VoteMachine() {
        partyList = new PartyList();
        voteList = new VoteList();
    }

    public static void main(String[] args) {
        new VoteMachine().start();
    }

    public void addParty(String party) {
        partyList.addParty(party);
    }

    public void vote(String party) {
        voteList.addVote(party);
    }

    public List<String> getParties() {
        return partyList.getParties();
    }

    public Map<String, Integer> getVotes() {
        return voteList.getVotes();
    }

    public void start() {
        voteTUIView = new VoteGUIView(this);
        partyList.addObserver(voteTUIView);
        voteList.addObserver(voteTUIView);
        voteTUIView.start();
    }
}
