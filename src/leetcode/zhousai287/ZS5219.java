package leetcode.zhousai287;

import java.util.Arrays;

public class ZS5219 {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int maxNum = 0, mid, left = 1, right = candies[candies.length - 1];
        while(left <= right){
            long count = 0;
            mid = left + (right - left) / 2;
            for(int i = candies.length - 1; i >= 0; i--){
                if(mid > candies[i]){
                    break;
                }else{
                    count += candies[i] / mid;
                }
                if(count >= k){
                    maxNum = mid;
                    left = mid + 1;
                    break;
                }
            }
            if(count < k){
                right = mid - 1;
            }
        }
        return (int)maxNum;
    }
}
