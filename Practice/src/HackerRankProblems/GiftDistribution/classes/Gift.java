package HackerRankProblems.GiftDistribution.classes;
import HackerRankProblems.GiftDistribution.intefaces.IGift;

public abstract class Gift implements IGift {
    String brandName;
    Gift(String brandName){
        this.brandName=brandName;
    }
    public abstract String getName();
}
