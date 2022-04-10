package leetcode.zhousai287;

import java.util.*;

public class ZS5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> winList = new ArrayList<>();
        List<Integer> loseList = new ArrayList<>();
        Map<Integer, Integer> winMap = new HashMap<>();
        Map<Integer, Integer> loserMap = new HashMap<>();
        for(int[] arr : matches){
            winMap.put(arr[0], winMap.getOrDefault(arr[0], 0) + 1);
            loserMap.put(arr[1], loserMap.getOrDefault(arr[1], 0) + 1);
        }

        for(int key : winMap.keySet()){
            if(loserMap.getOrDefault(key, -1) == -1){
                winList.add(key);
            }
        }
        for (int key : loserMap.keySet()){
            if(loserMap.get(key) == 1){
                loseList.add(key);
            }
        }
        Collections.sort(winList);
        Collections.sort(loseList);
        res.add(winList); res.add(loseList);
        return res;
    }
}
