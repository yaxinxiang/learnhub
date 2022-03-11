package lanqiao.java_2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Maze {
    public static char[][] chars;

    public static void main(String[] args) {
        chars = new char[10][10];
        Scanner sc = new Scanner(System.in);
        int res = 0;
        for (int i = 0; i < 10; i++) {
            chars[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Set<Integer> set = new HashSet<>();
                res += search(i, j, set);
            }
        }
        System.out.println(res);
    }

    public static int search(int x, int y, Set<Integer> set) {
        if (x < 0 || x >= chars.length || y < 0 || y >= chars.length) {
            return 1;
        }
        if (set.contains(x * 10 + y)) {
            return 0;
        }
        set.add(x * 10 + y);
        if (chars[x][y] == 'U') {
            return search(x - 1, y, set);
        } else if (chars[x][y] == 'D') {
            return search(x + 1, y, set);
        } else if (chars[x][y] == 'L') {
            return search(x, y - 1, set);
        } else {
            return search(x, y + 1, set);
        }
    }
}
