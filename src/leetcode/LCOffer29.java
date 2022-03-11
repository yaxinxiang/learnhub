package leetcode;

public class LCOffer29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int idx = 0;
        while(true){
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[up][i];
            }
            if(++up > down){
                break;
            }
            for (int i = up; i <= down ; i++) {
                res[idx++] = matrix[i][right];
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[down][i];
            }
            if(--down < up){
                break;
            }
            for (int i = down; i >= up ; i--) {
                res[idx++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}
