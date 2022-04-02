package lanqiao.java_2014;

import java.util.Scanner;

public class LQ1436 {
    static int[][] tre;
    static int[][] preMax;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        tre = new int[n][m]; preMax = new int[n][m]; dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tre[i][j] = preMax[i][j] = sc.nextInt();
                preMax[i][j] = getMax(preMax[i][j], i - 1 > 0 ? preMax[i - 1][j] : 0, j - 1 > 0 ? preMax[i][j - 1] : 0);
                getRoutes(i, j);
            }
        }
        System.out.println(dp[n - 1][m - 1]);
        sc.close();
    }

    public static int getMax(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static void getRoutes(int i, int j){
        if(i == 0 || j == 0){
            dp[i][j] = 1;
            return;
        }
        if(tre[i][j] > preMax[i - 1][j]){
            dp[i][j] += dp[i - 1][j];
        }
        if(tre[i][j] > preMax[i][j - 1]){
            dp[i][j] += dp[i][j - 1];
        }
    }
}
