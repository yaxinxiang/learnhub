package leetcode;

import java.util.*;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if(heap.isEmpty()){
                break;
            }
            res[i] = heap.poll()[0];
        }
        return res;
    }
}
