package leetcode;

public class LCOffer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                node = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                node = l2;
                l2= l2.next;
            }
        }
        node.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
