package lanqiao.java_2021;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        Set<String> lines = new HashSet<>();
        int[] points = new int[421];
        int num = 0;
        for(int x = 0; x < 20; x++){
            for(int y = 0; y < 21; y++){
            points[num++] = x * 100 + y;
            }
        }
        for(int i = 0; i < num; i++){
        int x1 = points[i] / 100, y1 = points[i] % 100;
        for(int j = i + 1; j < num; j++){
            int x2 = points[j] / 100, y2 = points[j] % 100;
            int up = y1 -y2, down = x1 - x2;
            if(down == 0){
                lines.add("x = " + x1);
                continue;
            }
            String k = up / gcd(up, down) + "/" + down / gcd(up, down);
            int up1 = y1 * down - up * x1;
            String b = up1/gcd(up1, down) + " " + down / gcd(up1, down);
            lines.add(k + " " + b);
            }
        }
        System.out.println(lines.size());
        scan.close();
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
