package lanqiao.java_2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ1433 {
    static boolean[] vis;
    static int[] vTime;
    static boolean[][] grid;
    static int n, m, start, end,times, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        grid = new boolean[n][n];
        vis = new boolean[n];
        vTime = new int[n];
        times = res = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            grid[x][y] = grid[y][x] = true;
        }
        start = sc.nextInt() - 1; end = sc.nextInt() - 1;
        search(start, new ArrayList<>(Arrays.asList(start)));
        for (int i = 0; i < n; i++) {
            if(vTime[i] == times && i != start && i != end){
                res++;
            }
        }
        System.out.println(res);
        sc.close();
    }
    static void search(int node, List<Integer> steps){
        if(node == end){
            times++;
            for(Integer thisNode : steps){
                vTime[thisNode]++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!vis[i] && grid[node][i]){
                vis[i] = true;
                steps.add(i);
                search(i, steps);
                steps.remove(steps.size() - 1);
                vis[i] = false;
            }
        }
    }
}
