package lanqiao.java_2013;

import java.util.Scanner;

public class CutGrid {
    public static int minCut = Integer.MAX_VALUE;
    public static boolean[][] vis;
    public static int[][] pos = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[n][m];
        vis = new boolean[n][m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                sum += grid[i][j];
            }
        }
        sum /= 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                vis[i][j] = true;
                search(grid, i, j, 1, sum - grid[i][j]);
                vis[i][j] = false;
            }
        }
        System.out.println(minCut == Integer.MAX_VALUE ? 0 : minCut);
        sc.close();
    }

    public static void search(int[][] grid, int x, int y, int step, int sum){
        if(sum < 0){
            return;
        }
        if(sum == 0){
            if(vis[0][0]){
                minCut = Math.min(minCut, step);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + pos[i][0], yy = y + pos[i][1];
            if(xx < 0 || yy < 0 || xx >= grid.length || yy >= grid[0].length || vis[xx][yy]){
                continue;
            }
            vis[xx][yy] = true;
            search(grid, xx, yy, step + 1, sum - grid[xx][yy]);
            vis[xx][yy] = false;
        }
    }
}
