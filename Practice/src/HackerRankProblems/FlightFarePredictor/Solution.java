package HackerRankProblems.FlightFarePredictor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        IFareTrendPredictor fareTrendPredictor = new FlightFarePredictor();

        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numberOfTests; i++) {
            // Example: Read the number of historical price points from the input
            int numberOfPrices = Integer.parseInt(scanner.nextLine().trim());
            String[] prices = scanner.nextLine().trim().split(" ");
            ArrayList<Integer> historicalPrices = new ArrayList<>();
            for (String price : prices) {
                historicalPrices.add(Integer.parseInt(price));
            }

            // Get the prediction from the fare trend predictor
            String recommendation = fareTrendPredictor.predictFareTrend(historicalPrices);
            System.out.println(recommendation);
        }
        scanner.close();
    }
}
