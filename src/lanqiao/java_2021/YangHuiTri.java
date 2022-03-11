package lanqiao.java_2021;

import java.util.Scanner;

public class YangHuiTri {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int k = 16; k >= 0; k--){
            int  head = 2 * k; //每列最小有效行
            int tail = Math.max(n, head); // 每列最大有效行
            int r = -1;
            while(head <= tail){
                int mid = (head + tail) >> 1;
                if(combination(mid, k, n) >= n){
                    tail = mid - 1;
                    r = mid;
                }else{
                    head = mid + 1;
                }
            }
            if(combination(r, k, n) == n){
                System.out.println((long)(r +1 ) * r/2 + k + 1);
                break;
            }
        }
        scan.close();
    }


    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long combination(long n , long k, long target){
        long up = 1, down = 1;
        if(k > n / 2){
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            up *= n - i + 1;
            down *= i;
            long g = gcd(up, down);
            up /= g;
            down /= g;
            if(up / down > target){
                return up /down;
            }
        }
        return up / down;
    }
}
