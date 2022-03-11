package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1748 {
    Map<Integer, Integer> map;
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        this.map = new HashMap<>();
        for (int num: nums) {
            int tmp = map.getOrDefault(num, 0);
            if(tmp == 0){
                sum += num;
            }else if(tmp == 1){
                sum -= num;
            }
            map.put(num, tmp + 1);
        }
        return sum;
    }
}
