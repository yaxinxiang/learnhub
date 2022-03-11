package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCOffer24 {
    //垃圾题解
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        for (int i = list.size() - 1; i > 0 ; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;
        return list.get(list.size() - 1);
    }

    //进阶版
    public ListNode reverseListPlus(ListNode head) {
        ListNode pos = head;
        ListNode pre = null;
        while(pos != null){
            ListNode tmp = pos.next;
            pos.next = pre;
            pre = pos;
            pos = tmp;
        }
        return pre;
    }
}

