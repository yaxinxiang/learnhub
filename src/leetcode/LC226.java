package leetcode;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left, right = root.right;
        root.left = right; root.right = left;
        reverse(left);
        reverse(right);
    }
}
