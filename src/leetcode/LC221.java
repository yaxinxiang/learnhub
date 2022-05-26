package leetcode;

public class LC221 {
    public char[][] matrix;

    /**
     * 暴力搜索
     * @param matrix 源数据
     * @return 最大正方形面积
     */
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        int maxLen = 0, len1 = matrix.length, len2 = matrix[0].length;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(matrix[i][j] == '1'){
                    int tail = Math.min(len1 - i, len2 - j);
                    for (int len = maxLen + 1; len <= tail; len++) {
                        if(isSquare(i, j, len)){
                            maxLen = len;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return maxLen * maxLen;
    }

    public boolean isSquare(int x, int y, int len){

        for(int i = x; i < x + len; i++){
            for (int j = y; j < y + len; j++) {
                if(matrix[i][j] == '0'){
                    return false;
                }else{
                    matrix[i][j] = '2';
                }
            }
        }
        return true;
    }


    /**
     * 动态规划，dp[i][j] 表示以i,j为右下角的最大正方形的边长
     * @param matrix 源数据
     * @return 最大正方形面积
     */
    public int maximalSquarePlus(char[][] matrix) {
        int maxLen = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    int L = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int U = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    int LU = (i - 1 >= 0) && (j - 1 >= 0) ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.min(LU, Math.min(L, U)) + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        LC221 lc221 = new LC221();
        int res = lc221.maximalSquare(matrix);
        System.out.println(res);
    }
}
