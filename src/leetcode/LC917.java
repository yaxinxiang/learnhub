package leetcode;

public class LC917 {
    public String reverseOnlyLetters(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, j = s.length() - 1; i < s.length(); i++) {
            while(j >= 0 && !isLetter(s.charAt(j))){
                j--;
            }
            if(!isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }else{
                sb.append(s.charAt(j));
                j--;
            }
        }
        return sb.toString();
    }

    public boolean isLetter(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
