package HackerRankProblems.GiftDistribution.classes;

import HackerRankProblems.GiftDistribution.intefaces.ICompany;

import java.util.ArrayDeque;
import java.util.Queue;

public class Company implements ICompany {
    int LaptopCount = 0;
    int MobilePhoneCount = 0;
    int ShoppingGiftCardCount = 0;
    private Queue<Gift> queue = new ArrayDeque<>();

    public void addGift(Gift gift) {
        queue.add(gift);
        if (gift instanceof Laptop) {
            LaptopCount++;
        } else if (gift instanceof MobilePhone) {
            MobilePhoneCount++;
        } else {
            ShoppingGiftCardCount++;
        }
    }

    public Gift giveaway() {
        return queue.poll();
    }

    @Override
    public int getLaptopCount() {
        return LaptopCount;
    }

    @Override
    public int getMobilePhoneCount() {
        return MobilePhoneCount;
    }

    @Override
    public int getShoppingGiftCardCount() {
        return ShoppingGiftCardCount;
    }
}
