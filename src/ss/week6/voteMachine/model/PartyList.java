package ss.week6.voteMachine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by simon on 20.12.16.
 */
public class PartyList extends Observable {
    private List<String> parties;

    public PartyList() {
        parties = new ArrayList<>();
    }

    public void addParty(String party) {
        parties.add(party);
        setChanged();
        notifyObservers();
    }

    public List<String> getParties() {
        return parties;
    }

    public boolean hasParty(String party) {
        return parties.contains(party);
    }
}
