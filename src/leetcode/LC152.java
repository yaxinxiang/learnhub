package leetcode;

public class LC152 {
    /**
     * 动态规划:
     * 由于含正负数字，所以在每一次更新最优解的时候要记录 最大乘积 和 最小乘积
     * 设当前值为num[i], 前子数组乘积最大值为fMax, 乘积最小值为fMin
     * 则以i结尾的最优子解为：max(num[i], fMax*num[i], fMin*num[i])
     * @param nums 数组（其中数字含正负）
     * @return 返回nums中乘积最大的连续子数组的乘积
     */
    public int maxProduct(int[] nums) {
        int fMin = nums[0], fMax = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMin = fMin, tmpMax = fMax;
            fMin = Math.min(nums[i], Math.min(tmpMin * nums[i], tmpMax * nums[i]));
            fMax = Math.max(nums[i], Math.max(tmpMin * nums[i], tmpMax * nums[i]));
            ans = Math.max(ans, fMax);
        }
        return ans;
    }
}
