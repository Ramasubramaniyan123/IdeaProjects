package HackerRankProblems.GiftDistribution.classes;

import HackerRankProblems.GiftDistribution.intefaces.IEmployee;

import java.util.ArrayList;
import java.util.List;

public class Employee implements IEmployee {
    String name;
    List<Gift> giftsOwned;

    public Employee(String name) {
        this.name = name;
        giftsOwned = new ArrayList<>();
    }

    @Override
    public void winGift(Gift gift) {
        if(gift!=null){
            giftsOwned.add(gift);
        }
    }

    @Override
    public List<String> getOwnedGiftNames() {
        List<String> names = new ArrayList<>();
        for (Gift gift : giftsOwned) {
            names.add(gift.getName());
        }
        return names;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
