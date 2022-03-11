package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC2006 {
    public int countKDifference1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = Math.abs(nums[i] - nums[j]);
                if(i != j && num == k){
                    res++;
                }
            }
        }
        return res;
    }
    public int countKDifference2(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            res += map.getOrDefault(k - num, 0);
            res += map.getOrDefault(num - k, 0);
            map.put(num, map.getOrDefault(num, 1));
        }
        return res;
    }
}
