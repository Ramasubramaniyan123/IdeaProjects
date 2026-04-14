package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithTargetSum {
    static void main() {
        int[] nums = {0,0,0};
        int t = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - t)) {
                count += map.get(sum - t);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
