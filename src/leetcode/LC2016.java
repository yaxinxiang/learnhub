package leetcode;

public class LC2016 {
    //O(n²)
    public int maximumDifference1(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]){
                    max = Math.max(nums[j] - nums[i], max);
                }
            }
        }
        return max;
    }
    //O(n)
    public int maximumDifference2(int[] nums) {
        int res = -1;
        int preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= preMin){
                res = Math.max(res, nums[i] - preMin);
            }else{
                preMin = nums[i];
            }
        }
        return res;
    }
}
