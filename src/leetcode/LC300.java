package leetcode;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int[] flag = new int[nums.length];
        Arrays.fill(flag, 1);
        int maxLen = 1, right = 0;
        while(right < nums.length){
            int left = right - 1;
            int tmpLen = 0;
            while(left >= 0){
                if(nums[left] < nums[right]){
                    tmpLen = Math.max(flag[left], tmpLen);
                }
                left--;
            }
            flag[right] += tmpLen;
            maxLen = Math.max(flag[right], maxLen);
            right++;
        }
        return maxLen;
    }
}
