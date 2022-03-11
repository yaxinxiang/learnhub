package lanqiao.practice;

import java.util.Arrays;
import java.util.Scanner;

public class JoinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
        }
        sc.close();
    }
}
