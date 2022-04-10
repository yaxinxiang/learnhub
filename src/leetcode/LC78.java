package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        int len = nums.length;
        search(0, nums, new ArrayList<>());
        return  list;
    }

    public void search(int n, int[] nums, List<Integer> tmpList){
        if(n == nums.length){
            list.add(new ArrayList<>(tmpList));
            return;
        }
        search(n + 1, nums, tmpList);
        tmpList.add(nums[n]);
        search(n + 1, nums, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }
}
