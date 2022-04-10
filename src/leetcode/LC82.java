package leetcode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode H = new ListNode(-1);
        H.next = head;
        deleteSame(head, H);
        return H.next;
    }

    public void deleteSame(ListNode head, ListNode before){
        if(head == null ||head.next == null){
            return;
        }
        ListNode tmp = head.next;
        while(tmp.val == head.val){
            tmp = tmp.next;
            if(tmp == null){
                break;
            }
        }
        if(tmp != head.next){
            before.next = tmp;
            deleteSame(tmp, before);
        }else{
            deleteSame(tmp, head);
        }
    }
}
