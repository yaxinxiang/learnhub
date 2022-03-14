package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加vis[] 标记会比直接使用list.contains快，contains本质上是遍历对比
 */
public class LC46 {
    boolean[] vis;
    List<List<Integer>> resList;
    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        resList = new ArrayList<>();
        search(nums, new ArrayList<>(), 0);
        return resList;
    }

    public void search(int[] nums, List<Integer> list, int depth){
        if(depth == nums.length){
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!vis[i]){
                vis[i] = true;
                list.add(nums[i]);
                search(nums, list, depth + 1);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
