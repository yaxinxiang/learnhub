package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC2465 {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if(!set.add(astr.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
