package HackerRankProblems.FlightFarePredictor;

import java.awt.*;
import java.util.ArrayList;

public class FlightFarePredictor implements  IFareTrendPredictor{

    @Override
    public String predictFareTrend(ArrayList<Integer> historicalPrices) {
        int inc=0;
        int dec=0;
        // int max=historicalPrices.get(0);
        for(int i=1;i<historicalPrices.size();i++){
            int prev=historicalPrices.get(i-1);
            int curr=historicalPrices.get(i);
            if(prev<curr){
                inc++;
            }
            else if(curr<prev){
                dec++;
            }

        }
        return inc>dec?"BUY":"WAIT";
    }

}
