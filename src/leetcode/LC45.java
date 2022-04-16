package leetcode;

import java.util.Arrays;

public class LC45 {
    /**
     * 时间复杂度O(n²)
     * 动态规划，找出每个位置的最小跳次
     * @param nums 非负整数数组
     * @return 最小跳次
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 时间复杂度O(n)
     * 下一跳的选择为：本次跳到的任意位置 j 加上nums[j] 为最大， 选择j
     * @param nums 非负整数数组
     * @return 最小跳次
     */
    public int jumpPlus(int[] nums) {
        int maxPos = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == end){
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
