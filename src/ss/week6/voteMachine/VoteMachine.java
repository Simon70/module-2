package ss.week6.voteMachine;

import ss.week6.voteMachine.model.PartyList;
import ss.week6.voteMachine.model.VoteList;

import java.util.List;
import java.util.Map;

/**
 * Created by simon on 20.12.16.
 */
public class VoteMachine {

    private static VoteView ui;
    private final PartyList partyList;
    private final VoteList voteList;

    public VoteMachine(PartyList partyList, VoteList voteList) {
        this.partyList = partyList;
        this.voteList = voteList;
    }

    public static void main(String[] args) {
        VoteMachine vm = new VoteMachine(new PartyList(), new VoteList());
        ui = new VoteTUIView(vm);
    }

    public void addParty(String party) {
        partyList.addParty(party);
    }

    public List<String> getParties() {
        return partyList.getParties();
    }

    public Map<String, Integer> getVotes() {
        return voteList.getVotes();
    }

    public void vote(String party) {

        voteList.vote(party);
    }
}
