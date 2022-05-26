package lanqiao.practice;

import java.util.Scanner;

public class LQ1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println(sc.nextLine() + "\n");
        }
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for(String tmp : s1){
                System.out.println(tmp + "\n");
            }
        }
        sc.close();
    }
}
