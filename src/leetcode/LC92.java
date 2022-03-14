package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while(node != null){
            ListNode tmp = node;
            list.add(tmp);
            node = node.next;
        }
        return reverseNodes(list, left - 1, right - 1);
    }

    private ListNode reverseNodes(List<ListNode> list, int left, int right){
        ListNode head = left - 1 < 0 ? new ListNode(Integer.MAX_VALUE) : list.get(left - 1), node = head;
        for (int i = right; i >= left; i--) {
            node.next = list.get(i);
            node = list.get(i);
            node.next = null;
        }
        if(right + 1 < list.size()){
            node.next = list.get(right + 1);
        }
        if(left > 0){
            list.get(left - 1).next = head.next;
            return list.get(0);
        }
        return head.next;
    }

    /**
     * 穿针引线法，一次遍历
     */
    public ListNode reverseBetweenPlus(ListNode head, int left, int right) {
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode pre = head,cur, next;
        for (int i = 0; i < left; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        for (int i = 0; i < left - right; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return headNode.next;
    }
}
