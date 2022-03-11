package leetcode;

public class TheLongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int len = s.length();
        int[] chars = new int[58];
        for (int i = 0; i < len; i++) {
            chars[s.charAt(i) - 65] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if(chars[i] == 0 && chars[i + 32] == 0){
                continue;
            }else if(chars[i] != chars[i + 32]){
                return null;
            }
        }
        return s;
    }
}
