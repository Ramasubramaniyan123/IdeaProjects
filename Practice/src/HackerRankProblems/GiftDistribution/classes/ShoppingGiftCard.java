package HackerRankProblems.GiftDistribution.classes;

public class ShoppingGiftCard extends Gift{
    ShoppingGiftCard(String brandName){
        super(brandName);
    }

    public String getName() {
        return  "Shopping Gift Card: " + brandName;
    }
}
