package leetcode;

public class LC2000 {
    public String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if(ch == word.charAt(i)){
                StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
                sb.reverse();
                return sb + word.substring(i + 1, word.length());
            }
        }
        return word;
    }
}
