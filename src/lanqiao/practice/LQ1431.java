package lanqiao.practice;

import java.util.Scanner;

public class LQ1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int n = sc.nextInt();
        int[] child = new int[n + 1];
        for (int i = 0; i < n; i++) {
            child[i] = sc.nextInt();
        }
        while(true){
            int count = 0;
            child[n] = child[0];
            for (int i = 0; i < n; i++) {
                if(child[i] == child[i + 1]){
                    continue;
                }
                count++;
                child[i] = child[i] / 2 + child[i + 1] / 2;
                if(child[i] % 2 != 0){
                    res++;
                    child[i] += 1;
                }
            }
            if(count == 0){
                break;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
