package lanqiao.practice;

import java.util.Scanner;

public class MinDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        int layer = 1;
        int sum = 0, max = 0, resLayer = 1;
        while(++i < n + 1){
            sum += sc.nextInt();
            int sn = (int)Math.pow(2, layer) - 1;
            if(i == sn){
                if(sum > max){
                    resLayer = layer;
                    max = sum;
                }
                layer++;
                sum = 0;
            }
            if(i == n){
                if(sum > max){
                    resLayer = layer;
                    max = sum;
                }
                sum = 0;
            }
        }
        System.out.println(resLayer);
        sc.close();
    }
}
