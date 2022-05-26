package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> table1 = addNode(l1), table2 = addNode(l2);
        if(table1.size() < table2.size()){
            List<ListNode> tmp = table1; table1 = table2; table2 = tmp;
        }
        int plus = 0, pos1 = table1.size() - 1, pos2 = table2.size() - 1;
        while(pos1 >= 0 || pos2 >= 0){
            int b = pos2 >= 0 ? table2.get(pos2--).val : 0;
            int a = table1.get(pos1).val + b + plus;
            plus = a / 10;
            table1.get(pos1--).val = a % 10;
        }
        if(plus == 1){
            ListNode head = new ListNode(1);
            head.next= table1.get(0);
            return head;
        }
        return table1.get(0);
    }

    public List<ListNode> addNode(ListNode node){
        List<ListNode> list = new ArrayList<>();
        while(node != null){
            list.add(node);
            node = node.next;
        }
        return list;
    }

    public ListNode addTwoNumbersPlus(ListNode l1, ListNode l2) {
        int len1 = length(l1), len2 = length(l2);
        if(len1 < len2){
            ListNode tmp = l1; l1 = l2; l2 = tmp;
            int tmpLen = len1; len1 = len2; len2 = tmpLen;
        }
        int plus = addNodes(l1, l2, len1 - len2);
        if(plus  == 1){
            ListNode head = new ListNode(1);
            head.next = l1;
            return head;
        }
        return l1;
    }

    public int addNodes(ListNode l1, ListNode l2, int zeroCount){
        if(l1 == null || l2 == null){
            return 0;
        }
        int plus = 0, b = 0;
        int thisPlus = zeroCount > 0 ? addNodes(l1.next, l2, zeroCount - 1) : addNodes(l1.next, l2.next, zeroCount - 1);
        if (zeroCount <= 0){
            b = l2.val;
        }
        int sum = b + l1.val + thisPlus;
        plus = sum / 10;
        l1.val = sum % 10;
        return plus;
    }

    public int length( ListNode node){
        int res = 0;
        while(node != null){
            res++;
            node = node.next;
        }
        return res;
    }
}
