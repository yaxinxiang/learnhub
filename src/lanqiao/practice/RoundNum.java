package lanqiao.practice;

import java.util.Scanner;

public class RoundNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int up = 0, down = m - 1, left = 0, right = n - 1;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        while(true){
            for (int i = up; i <= down; i++) {
                System.out.print(nums[i][left] + " ");
            }
            if(++left > right){
                break;
            }
            for (int i = left; i <= right; i++) {
                System.out.print(nums[down][i] + " ");
            }
            if(--down < up){
                break;
            }
            for (int i = down; i >= up ; i--) {
                System.out.print(nums[i][right] + " ");
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                System.out.print(nums[up][i] + " ");
            }
            if(++up > down){
                break;
            }
        }
    }
}
