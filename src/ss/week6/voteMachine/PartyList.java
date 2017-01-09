package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {

    private List<String> parties;

    //@ ensures getParties()!=null;
    public PartyList() {
        parties = new ArrayList<>();
    }

    //@ requires party!=null;
    //@ ensures !getParties().contains(party) ==> \old(getParties().size()) == getParties().size()+1;
    public void addParty(String party) {
        if (!parties.contains(party)) {
            parties.add(party);
            setChanged();
            notifyObservers("party");
        }
    }

    //@ pure;
    public List<String> getParties() {
        return parties;
    }

    public boolean hasParty(String party) {
        return parties.contains(party);
    }
}
