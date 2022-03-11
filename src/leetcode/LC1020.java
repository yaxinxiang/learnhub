package leetcode;

public class LC1020 {
    int[][] pos = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public boolean canPass = false;
    int num = 0;
    int tmp = 0;
    public int numEnclaves(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    canPass = false;
                    tmp = 0;
                    search(i, j, grid);
                    if(!canPass){
                        num += tmp;
                    }
                }
            }
        }
        return num;
    }

    public void search(int i, int j, int[][] grid){
        tmp += 1;
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int x = i + pos[k][0], y = j + pos[k][1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                canPass = true;
                continue;
            }
            if(grid[x][y] == 1){
                search(x, y, grid);
            }
        }
    }
}
