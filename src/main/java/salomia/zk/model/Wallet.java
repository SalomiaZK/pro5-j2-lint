package salomia.zk.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
public class Wallet {
    private final  String colour;
    private final String size;
    private final ArrayList<Money> money;
    private final boolean isLost;
    private State state;


    public ArrayList<Money> checkVola(Money money) {
        return this.money.stream().filter(money1 -> money1.equals(money) ).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Money> checkVola() {
        return getMoney();
    }

    public ArrayList<Money> addVola(ArrayList<Money> money) {
        this.money.addAll(money);
        return  this.money;
    }

    public State toggle(){
        if(this.getState() == State.OPEN){
            state= State.CLOSED;
        }
        else if(this.getState() == State.CLOSED){
            state= State.OPEN;
        }
        return state;

    }
}
