package lanqiao.java_2021;

import java.util.Scanner;

public class MinimumWeight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long sum = 0, times = 0;
        while(sum < x){
            sum += Math.pow(3, times);
            times++;
        }
        System.out.println(times);
    }
}
