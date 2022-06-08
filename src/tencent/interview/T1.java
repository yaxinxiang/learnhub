package tencent.interview;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个整数数组 a，其中数组内值在2到n（n为数组长度）之间, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。不用到任何额外空间并在O(n)时间复杂度内解决这个问题
 */
public class T1 {
    /**
     * 面试临场版，有弊端
     * @param nums 给定的数组
     * @return 重复的数字
     */
    public List<Integer> findReps(int[] nums){
        int flag = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(((flag>>nums[i]) & 1) == 1){
                res.add(nums[i]);
            }else{
                flag = flag ^ (1<<nums[i]);
            }
        }
        return res;
    }

    /**
     * 正确写法：原地hash 重复数字的索引位置会加上两次的n，所以大于2*n的为重复数字
     * @param nums 给定的数组
     * @return 重复的数字
     */
    public List<Integer> findRepsCorrect(int[] nums){
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++){
            int index = (nums[i] - 1) % n;
            nums[index] += n;
            if(nums[index] > 2 * n){
                res.add(index + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,4,5,6,8,8,9,10};
        List<Integer> res = new T1().findRepsCorrect(arr);
        System.out.println(res);
    }
}
