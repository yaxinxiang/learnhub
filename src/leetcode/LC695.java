package leetcode;

public class LC695 {
    int max = 0;
    int tmp = 0;
    int[][] pos = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    tmp = 0;
                    search(i, j , grid);
                }
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
    void search(int x, int y, int[][] grid){
        tmp++;
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int xx = x + pos[i][0], yy = y + pos[i][1];
            if(xx < 0 || xx >= grid.length || yy < 0 || yy >= grid[0].length){
                continue;
            }
            search(xx, yy, grid);
        }
        if(x - 1 >= 0 && grid[x - 1][y] == 1){
            search(x - 1, y, grid);
        }
        if(x + 1 < grid.length && grid[x + 1][y] == 1){
            search(x + 1, y, grid);
        }
        if(y - 1 >= 0 && grid[x][y - 1] == 1){
            search(x, y - 1, grid);
        }
        if(y + 1 < grid[0].length && grid[x][y + 1] == 1){
            search(x, y + 1, grid);
        }
    }
}
