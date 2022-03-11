package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length, column = matrix[0].length;
        Map<Integer, Integer> mini = new HashMap<>();
        for (int i = 0; i < row; i++) {
            int j = 0, miniNum = matrix[i][0];
            for (int k = 0; k < column; k++) {
                if(matrix[i][k] < miniNum){
                    j = k;
                    miniNum = matrix[i][k];
                }
            }
            boolean isOk = true;
            for (int k = 0; k < row; k++) {
                if(matrix[k][j] > miniNum){
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                list.add(miniNum);
            }
        }
        return list;
    }
}
