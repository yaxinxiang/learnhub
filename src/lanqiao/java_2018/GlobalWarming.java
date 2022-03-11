package lanqiao.java_2018;

import java.util.Scanner;

public class GlobalWarming {
    public static char[][] land;
    public static int[][] pos = {{0, -1}, {0, 1},{-1, 0}, {1, 0}};
    public static int sink = 0;
    public static int sum = 0; //沉默岛屿数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        land = new char[n][n];
        for (int i = 0; i < n; i++) {
            land[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(land[i][j] == '#'){
                    sum += 1;
                    sink = 0;
                    search(i, j);
                    sum -= sink;
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }

    //沉返回0，不沉返回1
    public static int isSink(int x, int y){
        for (int i = 0; i < 4; i++) {
            int xx = x + pos[i][0], yy = y + pos[i][1];
            if(xx < 0 || xx >= land.length || yy < 0 || yy >= land.length){
                continue;
            }
            if(land[xx][yy] == '.'){
                return 0;
            }
        }
        return 1;
    }

    public static void search(int x, int y){
        land[x][y] = '$';//标记
        if(sink == 0){
            sink = isSink(x, y); //判断
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + pos[i][0], yy = y + pos[i][1];
            if(xx < 0 || xx >= land.length || yy < 0 || yy >= land.length){
                continue;
            }
            if(land[xx][yy] == '#'){
                search(xx, yy);
            }
        }
    }
}