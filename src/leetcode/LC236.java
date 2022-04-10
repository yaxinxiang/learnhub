package leetcode;

public class LC236 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        tracert(root, p, q);
        return res;
    }
    public int tracert(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        int flag = tracert(root.left, p, q) + tracert(root.right, p, q);
        if(root == p || root == q){
            flag += 1;
        }
        if(res == null && flag == 2){
            res = root;
        }
        return flag;
    }
}
