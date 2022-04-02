package leetcode;

public class LC79 {
    boolean find = false;
    boolean[][] vis;
    int[][] position = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length && !find; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    findWord(board, word, 0, i, j);
                }
                if(find){
                    return true;
                }
            }
        }
        return find;
    }

    public void findWord(char[][] board, String word, int pos, int x, int y){
        if(board[x][y] != word.charAt(pos)){
            return;
        }
        if(pos == word.length() - 1){
            find = true;
            return;
        }
        vis[x][y] = true;
        for(int i = 0; i < 4; i++){
            int xx = x + position[i][0], yy = y + position[i][1];
            if(xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length || vis[xx][yy]){
                continue;
            }
            findWord(board, word, pos + 1, xx, yy);
        }
        vis[x][y] = false;
    }
}
