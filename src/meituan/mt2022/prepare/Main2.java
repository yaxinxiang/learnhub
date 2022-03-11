package meituan.mt2022.prepare;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int num = 0;
            for (int i = m; i <= n ; i++) {
                int tmp = i, res = 0;
                while(tmp > 0){
                    res += Math.pow(tmp % 10, 3);
                    tmp /= 10;
                }
                if(res == i){
                    System.out.print(i + " ");
                    num++;
                }
            }
            if(num == 0){
                System.out.println("no");
            }else{
                System.out.println();
            }
        }
        sc.close();
    }
}
