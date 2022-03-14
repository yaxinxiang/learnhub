package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC215 {
    /**
     * 偷懒写法，直接调用快排，返回第K大的数
     * @param nums 待排数组
     * @param k 第 k 大
     * @return 数组第k大的数
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 使用最小堆，容量k，root上的数为第k大的数
     * 这样做比快排耗时，但省了一定的空间
     * @param nums 待排数组 容量是>=k的
      * @param k 第 k 大
     * @return 数组第k大的数
     */
    public int findKthLargestPlus(int[] nums, int k) {
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            smallHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > smallHeap.peek()){
                smallHeap.poll();
                smallHeap.offer(nums[i]);
            }
        }
        return smallHeap.peek();
    }

    //暂未实现但可行的方法：手写快排
}
