package lanqiao.java_2013;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ1440 {
    static boolean[] vis;
    static int n, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vis = new boolean[10];
        res = 0;
        n = sc.nextInt();
        search(new ArrayList<>());
        System.out.println(res);
        sc.close();
    }

    public static void count(List<Integer> tmp){
        for(int i = 0; i < 8; i++){
            int a = getA(tmp, i);
            if(a >= n){
                break;
            }
            for(int j = i + 1; j < 8; j++){
                int b = getB(tmp, i + 1, j);
                if(b != -1 && a + b == n){
                    res++;
                }
            }
        }
    }
    public static int getA(List<Integer> tmp, int pos){
        int res = 0;
        for(int i = 0; i <= pos; i++){
            res = res * 10 + tmp.get(i);
        }
        return res;
    }

    public static int getB(List<Integer> tmp, int start, int pos){
        int up = 0, down = 0;
        for(int i = start; i <= pos; i++){
            up = up * 10 + tmp.get(i);
        }
        for (int i = pos + 1; i < tmp.size(); i++) {
            down = down * 10 + tmp.get(i);
        }
        if(up % down != 0){
            return - 1;
        }
        return up / down;
    }

    public static void search(List<Integer> tmp){
        if(tmp.size() == 9){
            count(tmp);
            return;
        }
        for(int i = 1; i < 10; i++){
            if(!vis[i]){
                vis[i] = true;
                tmp.add(i);
                search(tmp);
                tmp.remove(tmp.size() - 1);
                vis[i] = false;
            }
        }
    }
}
