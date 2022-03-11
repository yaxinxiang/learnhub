package leetcode;

public class LC415 {
    public String addStrings(String num1, String num2) {
        int plus = 0;
        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        StringBuilder s = new StringBuilder();
        while(len1 >=0 || len2 >= 0 || plus > 0){
            int a = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int b = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int c = a + b + plus;
            plus = c > 9 ? 1 : 0;
            s.append(c % 10);
            len1--; len2--;
        }
        s.reverse();
        return s.toString();
    }
}
