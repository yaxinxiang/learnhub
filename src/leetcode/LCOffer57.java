package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCOffer57 {
    //暴力枚举
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        for (int i = 1; i < target - 1; i++) {
            int tmp = i, sum = 0;
            while(sum < target){
                sum += tmp;
                if(sum == target){
                    int[] res = new int[tmp - i + 1];
                    for (int j = 0; j < tmp - i + 1; j++) {
                        res[j] = i + j;
                    }
                    lists.add(res);
                    break;
                }
                tmp++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }

    //双指针
    public int[][] findContinuousSequencePlus(int target) {
        List<int[]> lists = new ArrayList<>();
        int left = 1, right = 2;
        while(left < right){
            int sum = (left + right) * (right - left + 1) / 2;
            if(sum == target){
                int[] res = new int[right - left + 1];
                for(int i = 0; i < res.length; i++){
                    res[i] = i + left;
                }
                lists.add(res);
                left++;
            }else if(sum < target){
                right++;
            }else{
                left++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
