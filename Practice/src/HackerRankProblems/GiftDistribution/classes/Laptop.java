package HackerRankProblems.GiftDistribution.classes;

public class Laptop extends Gift{

    Laptop(String brandName) {
        super(brandName);
    }

    public String getName() {
        return "Laptop: " + brandName;
    }
}
