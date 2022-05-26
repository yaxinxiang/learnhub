package lanqiao.practice;

import java.util.Scanner;

public class LQ1443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), k = sc.nextLong(), t = sc.nextLong();
        long sum = 1, num = 1, a1 = 1, an = n;
        for (int i = 1; i < t; i++) {
            num =  (num + (n * (a1 + an) / 2) % k)% k;
            sum += num;
            a1 = an + 1; an = an + n;
        }
        System.out.println(sum);
        sc.close();
    }
}