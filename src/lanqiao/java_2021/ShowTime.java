package lanqiao.java_2021;

import java.util.Scanner;

public class ShowTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        n /= 1000;
        n %= (24 * 60 * 60);
        long hours = n / 3600;
        long minutes = n / 60 % 60;
        long seconds = n % 60;
        System.out.printf("%02d:%02d:%02d",hours, minutes, seconds);
        scan.close();
    }
}
