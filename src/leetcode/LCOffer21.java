package leetcode;

public class LCOffer21 {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            while(i < j && (nums[i] & 1) == 1){
                i++;
            }
            while(i < j && (nums[j] & 1) == 0){
                j--;
            }
            int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
        }
        return nums;
    }
}
