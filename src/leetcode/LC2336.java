package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC2336 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 1, head = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                maxLen = Math.max(maxLen, i - head + 1);
                head = map.get(ch) + 1;
            }
            map.put(ch, i);
        }
        return maxLen;
    }
}
