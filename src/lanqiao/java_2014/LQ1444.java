package lanqiao.java_2014;

import java.util.Scanner;

/**
 * 超时暴力写法，正解没写出来
 */
public class LQ1444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), m = sc.nextLong(), p = sc.nextLong();
        long fm = 1, res = 2, pre1 = 1, pre2 = 1;
        long i;
        long tail = Math.max(n, m);
        for(i = 3; i <= tail; i++){
            long now = (pre1 + pre2);
            pre1 = pre2; pre2 = now;
            if(i == m){
                fm = now;
            }
            if(i <= n){
                res += now;
            }
        }
        System.out.println(res + " " + fm);
        System.out.println(res % fm % p);
        sc.close();
    }
}
