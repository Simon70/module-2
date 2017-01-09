package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {

	private VoteView	voteTUIView;
	private PartyList	partyList;
	private VoteList	voteList;

	public VoteMachine() {
		partyList = new PartyList();
		voteList = new VoteList();
		start();
	}

	public void addParty(String party) {
		partyList.addParty(party);
	}

	public void vote(String party) {
		voteList.addVote(party);
	}

	public static void main(String[] args) {
		new VoteMachine();
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
