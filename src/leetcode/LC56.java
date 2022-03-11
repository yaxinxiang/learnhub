package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > list.get(list.size() - 1)[1]){
                list.add(intervals[i]);
            }else{
                int before = list.get(list.size() - 1)[1];
                list.get(list.size() - 1)[1] = Math.max(before, intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
