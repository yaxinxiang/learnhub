package leetcode;

public class LC55 {
    boolean can;
    public boolean canJump(int[] nums) {
        can = false;
        int maxTo = 0;
        for(int i = 0; i < nums.length; i++){
            if(i <= maxTo){
                maxTo = Math.max(i + nums[i], maxTo);
                if(maxTo >= nums.length - 1){
                    can = true;
                    break;
                }
            }else{
                break;
            }
        }
        return can;
    }
}
