package lanqiao.practice;

import java.util.Scanner;

public class LQ1116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip;
        while(sc.hasNext() && !(ip = sc.nextLine()).equals("End of file")){
            String[] nums = ip.split("\\.");
            boolean flag = true;
            for(String num : nums){
                flag = check(num);
                if(!flag){
                    System.out.println("N");
                    break;
                }
            }
            if(flag){
                System.out.println("Y");
            }
        }

        sc.close();
    }

    public static boolean check(String num){
        if(num.length() > 3){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if(n < 0 || n > 9){
                return false;
            }
            sum = sum * 10 + n;
        }
        return sum < 256;
    }
}
