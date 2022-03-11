package meituan.mt2022;

import java.util.Scanner;

//Wrong
public class Main5 {
    public static boolean[] have = new boolean[10];
    public static boolean[] flag = new boolean[10]; // 标记确定没有的为true
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String last = null;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String num = sc.next();
            int a = sc.nextInt(), b = sc.nextInt();
            if(a == 0 && b == 0){
                for (int j = 0; j < n; j++) {
                    flag[Integer.parseInt(num.substring(j, j+1))] = true;
                }
            }
            if(last == null){
                last = num;
                if(a > 0){
                    for (int j = 0; j < n; j++) {
                        have[Integer.parseInt(num.substring(j, j+1))] = true;
                    }
                }
            }else {
                if(a > 0){
                    for(int j = 0; j < n; j++){
                        if(num.charAt(j) == last.charAt(j)){
                            have[Integer.parseInt(num.substring(j, j+1))] = true;
                        }else{
                            have[Integer.parseInt(last.substring(j, j+1))] = false;
                            have[Integer.parseInt(num.substring(j, j+1))] = false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if(flag[i]){
                have[i] = false;
            }
            if(n > 0 && have[i]){
                System.out.print(i);
                n--;
            }
        }
        sc.close();
    }
}
