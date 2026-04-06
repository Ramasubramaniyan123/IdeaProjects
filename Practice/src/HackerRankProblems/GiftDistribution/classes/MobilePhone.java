package HackerRankProblems.GiftDistribution.classes;

public class MobilePhone extends Gift{
    MobilePhone(String brandName) {
        super(brandName);
    }

    @Override
    public String getName() {
        return "Mobile Phone: " + brandName;
    }

}
