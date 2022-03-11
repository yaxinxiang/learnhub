package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if(list.get(i) != list.get(len - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
