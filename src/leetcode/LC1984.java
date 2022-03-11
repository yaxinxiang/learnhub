package leetcode;

import java.util.Arrays;

public class LC1984 {
    public int minimumDifference(int[] nums, int k) {
        if(k < 2){
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[nums.length - 1] - nums[0];
        for(int i = 0; i < nums.length - k + 1; i++){
            min = Math.min(min, nums[i + k -1] - nums[i]);
        }
        return min;
    }
}
