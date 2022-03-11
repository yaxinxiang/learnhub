package leetcode;

/**
 * 求root树中的最长路径
 */
public class LC543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findMaxLength(root);
        return res;
    }

    public int findMaxLength(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = findMaxLength(root.left);
        int R = findMaxLength(root.right);
        res = Math.max(L + R, res);
        return Math.max( L + 1, R + 1);
    }
}
