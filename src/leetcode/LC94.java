package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ergodic(root, list);
        return list;
    }

    public void ergodic(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        ergodic(root.left, list);
        list.add(root.val);
        ergodic(root.right, list);
    }
}
