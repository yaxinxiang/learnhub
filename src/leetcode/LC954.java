package leetcode;

import java.util.*;

public class LC954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> (Math.abs(a) - Math.abs(b)));
        for(int key : list){
            int keyNum = map.get(key), goal, goalNum;
            if(keyNum == 0){
                continue;
            }
            goal = 2 * key; goalNum = map.getOrDefault(goal, -1) - keyNum;
            if(goalNum < 0){
                return false;
            }
            map.put(key, 0);
            map.put(goal, goalNum);
        }
        return true;
    }
}
