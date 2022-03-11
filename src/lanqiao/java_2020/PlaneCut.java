package lanqiao.java_2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PlaneCut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int res = 1;
        Set<Line> set = new HashSet<>();
        Set<String> lines = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Line line = new Line();
            line.k = sc.nextInt();
            line.b = sc.nextInt();
            String s = line.k + " " + line.b;
            if(lines.contains(s)){
                continue;
            }
            Set<String> points = new HashSet<>();
            for (Line line1 : set) {
                if(line.k == line1.k){
                    continue;
                }
                int up = line.b - line1.b, down = line1.k - line.k, gcd1 = gcd(up, down);
                up /= gcd1; down /= gcd1;
                String x = up + " " + down;
                String y = up * line.k/gcd(line.k, down) + " " + down / gcd(line.k, down) + " " + line.b;
                points.add(x + " " + y);
            }
            set.add(line);
            lines.add(s);
            res += points.size() + 1;
        }
        System.out.println(res);
        sc.close();
    }

    static class Line{
        public int k;
        public int b;
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
