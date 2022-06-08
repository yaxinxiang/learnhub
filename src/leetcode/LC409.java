package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC409 {
    public int longestPalindrome(String s) {
        int[] tag = new int[128];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            tag[s.charAt(i) - 'A']++;
        }
        for(int num : tag){
            res += num>>1<<1;
            if(res % 2 == 0 && num % 2 == 1){
                res++;
            }
        }
        return res;
    }

    public int longestPalindromePlus(String s) {
        int[] tag = new int[128];
        int res = 0, odd = 0;
        for (int i = 0; i < s.length(); i++) {
            tag[s.charAt(i) - 'A']++;
        }
        for(int num : tag){
            if((num & 1) == 0){
                res += num;
            }else{
                res += num - 1;
                odd = 1;
            }
        }
        return res + odd;
    }
}
