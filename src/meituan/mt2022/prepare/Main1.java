package meituan.mt2022.prepare;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double n = sc.nextInt();
            int m = sc.nextInt();
            double res = n;
            while(--m > 0){
                n = Math.sqrt(n);
                res += n;
            }
            System.out.printf("%.2f", res);
        }
    }
}
