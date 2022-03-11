package lanqiao.java_2020;

public class SevenCodes {
    public static int ans = 0;
    public static boolean[][] uv = new boolean[7][7];
    public static boolean[] light = new boolean[7];
    public static boolean[] vis = new boolean[7];

    public static void main(String[] args) {
        uv[0][1] = true; uv[0][5] = true;
        uv[1][0] = true; uv[1][6] = true; uv[1][2] = true;
        uv[2][1] = true; uv[2][6] = true; uv[2][3] = true;
        uv[3][2] = true; uv[3][4] = true;
        uv[4][3] = true; uv[4][6] = true; uv[4][5] = true;
        uv[5][4] = true; uv[5][6] = true; uv[5][0] = true;
        uv[6][1] = true; uv[6][2] = true; uv[6][4] = true; uv[6][5] = true;
        for(int i = 1; i < 1<< 7; i++){
            initState(i);
            for (int j = 0; j < 7; j++) {
                if(light[j]){
                    vis[j] = true;
                    bfs(j);
                    break;
                }
            }
            ans++;
            for (int j = 0; j < 7; j++) {
                if(light[j] && !vis[j]){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    public static void initState(int x){
       for(int i = 6; i >= 0; i--){
           vis[i] = light[i] = false;
           light[i] = ((x >> i) & 1) == 1;
       }
    }
    public static void bfs(int i){
        for (int j = 0; j < 7; j++) {
            if(uv[i][j] && light[j] && !vis[j]){
                vis[j] = true;
                bfs(j);
            }
        }
    }
}
