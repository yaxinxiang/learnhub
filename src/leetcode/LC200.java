package leetcode;

public class LC200 {
    private int land = 0;
    private int[][] pos = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    land++;
                    search(i, j, grid);
                }
            }
        }
        return land;
    }

    private void search(int i, int j, char[][] grid){
        grid[i][j] = '2';
        for (int[] po : pos) {
            int x = i + po[0], y = j + po[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                continue;
            }
            if (grid[x][y] == '1') {
                search(x, y, grid);
            }
        }
    }
}
