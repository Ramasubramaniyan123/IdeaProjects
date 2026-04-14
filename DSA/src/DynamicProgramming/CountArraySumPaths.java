package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountArraySumPaths {
    static Map<Integer,Integer> map = new HashMap<>();
    public  static int count(int[] arr, int i){
        int n = arr.length;
        if( i == n) return  1;
        if(i > n)  return 0;

        if(map.containsKey(i)) return map.get(i);
        int res = count(arr,i+1)+ count(arr,i+2);
        map.put(i,res);
        return res;
    }

    static void main() {
        int[] arr = {1, 2, 3, 4, 5,7};
        int ans = count(arr, 0);

        System.out.println(ans);
    }
}
