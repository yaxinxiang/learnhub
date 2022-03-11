package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        addPaths(root, "");
        return res;
    }
    public void addPaths(TreeNode root, String path){
        if(root == null){
            return;
        }
        if(path.equals("")){
            path += root.val;
        }else {
            path += "->" + root.val;
        }
        if(root.left == null && root.right == null){
            res.add(new String(path));
            return;
        }
        addPaths(root.left, path);
        addPaths(root.right, path);
    }
}
