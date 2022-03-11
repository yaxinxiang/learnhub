package leetcode;

public class LC5 {
    public String longestPalindrome(String s) {
        int maxLen = 0, left = 0, right = 0;
        boolean[][] dp;
        char[] chars = s.toCharArray();
        int len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //枚举字串长度
        for (int i = 2; i <= len; i++) {
            //起始点
            for (int j = 0; j + i - 1 < len; j++) {
                int k = i + j - 1;
                if(i == 2){
                    dp[j][k] = chars[j] == chars[k];
                }else{
                    dp[j][k] = dp[j + 1][k - 1] && (chars[j] == chars[k]);
                }
                if(dp[i][j] && i > maxLen){
                    maxLen = i; left = j; right = k;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
