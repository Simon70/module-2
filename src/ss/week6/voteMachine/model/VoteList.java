package ss.week6.voteMachine.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simon on 20.12.16.
 */
public class VoteList {
    private Map<String, Integer> votes;

    public VoteList() {
        votes = new HashMap<>();
    }

    public void vote(String party) {
        votes.put(party, votes.remove(party) + 1);
    }

    public Map<String, Integer> getVotes() {
        return votes;
    }
}
