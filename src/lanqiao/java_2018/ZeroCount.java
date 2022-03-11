package lanqiao.java_2018;

import java.util.Scanner;

public class ZeroCount {
    public static void main(String[] args) {
        int five = 0, two = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            int tmp = sc.nextInt();
            while(tmp % 2 == 0){
                tmp /= 2;
                two++;
            }
            while(tmp % 5 == 0){
                tmp /= 5;
                five++;
            }
        }
        System.out.println(Math.min(two, five));
    }
}
