package meituan.mt2021;

import java.util.Scanner;

public class MT01 {
    static String accept = "Accept";
    static String wrong = "Wrong";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if(isValid(str.toCharArray())){
                System.out.println(accept);
            }else{
                System.out.println(wrong);
            }
        }
    }

    public static boolean isValid(char[] username){
        int len = username.length;
        if(len < 2 || !isLetter(username[0])){
            return false;
        }
        int letter = 1, num = 0;
        for (int i = 1; i < len; i++) {
            char ch = username[i];
            if(isLetter(ch)){
                letter++;
            }else if(isNum(ch)){
                num++;
            }
        }
        return num > 0 && num + letter == len;
    }

    public static boolean isLetter(char ch){
        if(ch>= 'a' && ch <= 'z'){
            return true;
        }
        return ch >= 'A' && ch <= 'Z';
    }
    public static boolean isNum(char ch){
        return ch >= '0' && ch <= '9';
    }
}
