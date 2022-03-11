package meituan.mt2022;

import java.util.Arrays;
import java.util.Scanner;

//AC
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1] && nums[i] != last + 1){
                res++;
                last = nums[i];
            }
        }
        System.out.println(res);
        sc.close();
    }
}
