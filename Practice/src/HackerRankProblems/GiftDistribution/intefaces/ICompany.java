package HackerRankProblems.GiftDistribution.intefaces;

import HackerRankProblems.GiftDistribution.classes.Gift;

public interface ICompany {
    void addGift(Gift gift);
    Gift giveaway();
    int getLaptopCount();
    int getMobilePhoneCount();
    int getShoppingGiftCardCount();
}
