package leetcode;

import java.util.*;

public class LC350 {
    /*事实告诉我们，使用List然后通过流的方式转换成结果数组的方式会大大降低运行效率 */
    public int[] intersectPlus(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        int i = 0, j = 0, num1Len = nums1.length, num2Len = nums2.length;
        int[] res = new int[Math.min(num1Len, num2Len)];
        int pos = 0;
        while(i < num1Len && j < num2Len){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                res[pos++] = nums1[i]; i++; j++;
            }
        }
        return Arrays.copyOfRange(res, 0, pos);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Map = intToMap(nums1);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int pos = 0;
        for (int num : nums2){
            int contains = num1Map.getOrDefault(num, 0);
            if(contains > 0){
                res[pos++] = num;
                num1Map.put(num, contains - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, pos);
    }

    public Map intToMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
}
