package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            int x = (num - 1) % len;
            nums[x] += len;
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] <= len){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
