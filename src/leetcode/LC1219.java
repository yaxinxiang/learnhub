package leetcode;

import java.util.Arrays;

public class LC1219 {
    public int maxValue = 0;
    public boolean[][] vis;
    public int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int getMaximumGold(int[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (boolean[] vi : vis) {
                    Arrays.fill(vi, false);
                }
                if(grid[i][j] == 0){
                    continue;
                }
                vis[i][j] = true;
                findMax(grid, i, j, grid[i][j]);
                vis[i][j] = false;
            }
        }
        return maxValue;
    }

    public void findMax(int[][] grid, int i, int j, int nowValue){
        if(!check(grid, i, j)){
            maxValue = Math.max(nowValue, maxValue);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + pos[k][0], y = j + pos[k][1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                continue;
            }
            if(!vis[x][y] && grid[x][y] > 0){
                vis[x][y] = true;
                findMax(grid, x, y, nowValue + grid[x][y]);
                vis[x][y] = false;
            }
        }
    }

    public boolean check(int[][] grid, int i, int j){
        for (int k = 0; k < 4; k++) {
            int x = i + pos[k][0], y = j + pos[k][1];
            if(x <0 || x >= grid.length || y < 0 || y >= grid[0].length){
                continue;
            }
            if(grid[x][y] > 0 && !vis[x][y]){
                return true;
            }
        }
        return false;
    }
}
