package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC83 {
    //适用没有排序的链表，但对于排过序的链表这样处理较慢
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head, pre = head;
        while(node != null){
            if(!set.add(node.val)){
                pre.next = node.next;
                node = node.next;
            }else{
                pre = node;
                node = node.next;
            }
        }
        return head;
    }

    //速度较快，但是不能处理无序链表去重
    public ListNode deleteDuplicatesPlus(ListNode head){
        int preVal = head.val;
        ListNode node = head, pos = head;
        while((node = node.next) != null){
            if(preVal != node.val){
                preVal = node.val;
                pos.next = node;
                pos = node;
            }
        }
        pos.next = null;
        return head;
    }
}
