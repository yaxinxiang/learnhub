package ali;

import java.util.Scanner;

public class Ali01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0, i = 2;
        while(i < s.length()){
            int n = 0;
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                n = c - '0';
            }else{
                n = 10 + c - 'a';
            }
            while(n > 0){
                if((n & 1) == 1){
                    res++;
                }
                n >>= 1;
            }
            i++;
        }
        System.out.println(res);
        sc.close();
    }
}
