package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {

    private Map<String, Integer> votes;

    //@ ensures getVotes() != null;
    public VoteList() {
        votes = new HashMap<String, Integer>();
    }

    public void addVote(String party) {
        if (votes.containsKey(party)) {
            votes.put(party, votes.get(party) + 1);
        } else {
            votes.put(party, 1);
        }

        setChanged();
        notifyObservers("vote");
    }

    //@ ensures \result != null;
    public Map<String, Integer> getVotes() {
        return votes;
    }
}
