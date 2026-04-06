package HackerRankProblems.GiftDistribution.intefaces;


import HackerRankProblems.GiftDistribution.classes.Gift;

import java.util.List;

public interface IEmployee {
    void winGift(Gift gift);
    List<String> getOwnedGiftNames();
}
