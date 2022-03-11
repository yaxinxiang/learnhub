package lanqiao.practice;

import java.util.Scanner;

public class BigNumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int posA = a.length() - 1, posB = b.length() - 1, plus = 0;
        while(posA >= 0 || posB >= 0){
            int numA = posA >= 0 ? a.charAt(posA) - '0' : 0;
            int numB = posB >= 0 ? b.charAt(posB) - '0' : 0;
            int numC = numA + numB + plus;
            sb.append(numC % 10);
            plus = numC > 9 ? 1 : 0;
            posA--; posB--;
        }
        if(plus > 0){
            sb.append("1");
        }
        System.out.println(sb.reverse());
        System.out.println();
        sc.close();
    }
}
