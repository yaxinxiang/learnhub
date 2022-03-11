package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findRightNode(root, list, 0);
        return list;
    }

    //深度优先搜索，比层序遍历要好
    public void findRightNode(TreeNode root, List<Integer> list, int level){
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add(root.val);
        }else{
            list.set(level, root.val);
        }
        findRightNode(root.left, list, level + 1);
        findRightNode(root.right, list, level + 1);
    }
}
