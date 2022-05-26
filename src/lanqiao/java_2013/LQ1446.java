package lanqiao.java_2013;

import java.util.Scanner;

public class LQ1446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int tmp = a * b / gcd(a, b);
        System.out.println(tmp * c / gcd(tmp, c));
        sc.close();
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
