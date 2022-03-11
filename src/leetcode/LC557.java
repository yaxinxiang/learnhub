package leetcode;

public class LC557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] list = s.split(" ");
        for (int i = 0; i < list.length; i++) {
            sb.append(new StringBuilder(list[i]).reverse());
            if(i != list.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
