package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums){
            set.add(num);
        }
        for (Integer num : set){
            if(set.contains(num - 1)){
                continue;
            }
            int count = 1;
            while(set.contains(num + count)){
                count++;
            }
            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }
}
