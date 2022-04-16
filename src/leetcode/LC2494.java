package leetcode;

public class LC2494 {
    /**
     * 这写法可以转换成循环，但在力扣上提交内存消耗差看不出来
     */
    int plus = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = countNodes(l1), len2 = countNodes(l2);
        if(len1 < len2){
            ListNode tmp; tmp = l1; l1 = l2; l2 = tmp;
        }
        plus = 0;
        addNodes(l1, l2);
        return l1;
    }

    public void addNodes(ListNode l1, ListNode l2){
        if(l1 == null){
            return;
        }
        int num = l1.val + plus + (l2 == null ? 0 : l2.val);
        l1.val = num % 10; plus = num / 10;
        if(l1.next == null){
            if(plus == 1){
                l1.next = new ListNode(1);
            }
            return;
        }
        addNodes(l1.next, l2 == null ? null : l2.next);
    }

    public int countNodes(ListNode node){
        int len = 0;
        while (node != null){
            len++;
            node= node.next;
        }
        return len;
    }
}
