package leetcode;

//二分递归将有序数组生成平衡二叉树
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return addNode(nums, 0, nums.length - 1);
    }
    public TreeNode addNode(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = addNode(nums, left, mid - 1);
        node.right = addNode(nums, mid + 1, right);
        return node;
    }
}
