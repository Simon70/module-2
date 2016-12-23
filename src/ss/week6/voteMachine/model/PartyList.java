package ss.week6.voteMachine.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 20.12.16.
 */
public class PartyList {
    private List<String> parties;

    public PartyList() {
        parties = new ArrayList<>();
    }

    public void addParty(String party) {
        parties.add(party);
    }

    public void removeParty(String party) {
        parties.remove(party);
    }

    public List<String> getParties() {
        return parties;
    }

    public boolean hasParty(String party) {
        return parties.contains(party);
    }
}
