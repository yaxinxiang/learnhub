package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int up = 0, left = 0, down = matrix.length - 1, right = matrix[0].length - 1;
        while(true){
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if(++up > down){
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if(--down < up){
                break;
            }
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC54 lc54 = new LC54();
        int[][] arr = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> list = lc54.spiralOrder(arr);
        for (Integer num : list){
            System.out.print(num + " ");
        }
    }
}
