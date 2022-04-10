package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC113 {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        findTargetPath(targetSum, root, new ArrayList<>());
        return list;
    }

    public void findTargetPath(int target, TreeNode root, List<Integer> tmpList){
        if(root == null){
            return;
        }
        int val = root.val;
        tmpList.add(val);
        if(target - val == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<>(tmpList));
        }
        findTargetPath(target - val, root.left, tmpList);
        findTargetPath(target - val, root.right, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }
}
