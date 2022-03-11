package leetcode;

public class LC53 {
    public int maxSubArray(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            maxNum = Math.max(maxNum, nums[i]);
        }
        return maxNum;
    }
}
