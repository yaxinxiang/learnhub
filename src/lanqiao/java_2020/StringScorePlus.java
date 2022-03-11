package lanqiao.java_2020;

import java.util.Scanner;

public class StringScorePlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        long num = 0;
        for(int i = 0; i < str.length(); i++){
            int tail = i + 1;
            for (; tail < str.length(); tail++){
                if(str.charAt(i) == str.charAt(tail)){
                    break;
                }
            }
            num += (long) (i + 1) * (tail - i);
        }
        System.out.println(num);
    }
}
