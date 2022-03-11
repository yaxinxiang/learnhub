package meituan.mt2022;

import java.util.Scanner;

//Wrong
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int choice = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            if(choice == 1){
                for (int j = left; j <= right; j++) {
                    res += nums[i];
                }
            }else{
                int k = sc.nextInt();
                for (int j = left; j <= right; j++) {
                    nums[i] += k;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
