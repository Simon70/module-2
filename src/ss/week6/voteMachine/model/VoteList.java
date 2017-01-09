package ss.week6.voteMachine.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by simon on 20.12.16.
 */
public class VoteList extends Observable {
    private Map<String, Integer> votes;

    public VoteList() {
        votes = new HashMap<>();
    }

    public Map<String, Integer> getVotes() {
        return votes;
    }

    public void addVote(String party) {
        if (votes.containsKey(party)) {
            votes.put(party, votes.remove(party) + 1);
        } else {
            votes.put(party, 1);
        }
        setChanged();
        notifyObservers();
    }
}
