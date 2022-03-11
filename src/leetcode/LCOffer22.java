package leetcode;

public class LCOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        while(k-- > 0){
            tail = tail.next;
        }
        while(tail != null){
            head = head.next;
            tail = tail.next;
        }
        return head;
    }
}
