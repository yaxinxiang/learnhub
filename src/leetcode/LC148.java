package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC148 {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        list.sort((o1, o2)->(o1.val - o2.val));
        for (int i = 0; i < list.size(); i++) {
            if(i < list.size() - 1){
                list.get(i).next = list.get(i + 1);
            }else{
                list.get(i).next = null;
            }
        }
        return list.get(0);
    }
}
