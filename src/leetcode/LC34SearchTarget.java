package leetcode;

public class LC34SearchTarget {
    public int[] searchRange(int[] nums, int target) {
        int first = binSearch(nums, target);
        int end = binSearch(nums, target + 1) - 1;
        return new int[]{first, end - 1};
    }

    /**
     * 查找target的第一个位置
     * @param nums 数组
     * @param target 目标数
     * @return first pos of target
     */
    public int binSearch(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
