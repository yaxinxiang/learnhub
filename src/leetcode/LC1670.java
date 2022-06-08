package leetcode;

/**
 * 使用链表实现了一个前中后队列的数据结构
 */
public class LC1670 {
}

class Node {
    int val;
    Node pre, next;
    public Node (int val){
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}

class FrontMiddleBackQueue {
    int count;
    Node head, mid, tail;
    boolean flag;
    public FrontMiddleBackQueue() {
        count = 0;
        flag = true;
    }

    public  void printInfo(){
        Node tmp = head;
        int i = 1;
        while(tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
        System.out.println("head: " + (head == null ? "null":head.val + " " + head));
        System.out.println("mid: " + (mid == null ? "null":mid.val + " " + mid));
        System.out.println("tail: " + (tail == null ? "null":tail.val + " " + tail));
    }

    public void pushFront(int val) {
        Node newNode = new Node(val);
        if(count == 0){
            head = mid = tail = newNode;
        }else if(count == 1){
            head = mid = newNode;
            newNode.next = tail;
            tail.pre = newNode;
        }else{
            if(!flag){
                mid = mid.pre;
            }
            head.pre = newNode;
            newNode.next = head;
            head = newNode;
        }
        flag = !flag;
        count++;
    }

    public void pushMiddle(int val) {
        Node newNode = new Node(val);
        if(count == 0) {
            head = mid = tail = newNode;
        }else if(count == 1){
            head = mid = newNode;
            newNode.next = tail;
            tail.pre = newNode;
        }else{
            if(flag){
                newNode.next = mid.next;
                mid.next.pre = newNode;
                mid.next = newNode;
                newNode.pre = mid;
                mid = newNode;
            }else{
                mid.pre.next = newNode;
                newNode.pre = mid.pre;
                newNode.next = mid;
                mid.pre = newNode;
                mid = newNode;
            }
        }
        flag = !flag;
        count++;
    }

    public void pushBack(int val) {
        Node newNode = new Node(val);
        if(count == 0) {
            head = mid = tail = newNode;
        }else if(count == 1){
            tail = newNode;
            mid.next = tail;
            tail.pre = mid;
        }else{
            if(flag){
                mid = mid.next;
            }
            tail.next = newNode;
            newNode.pre = tail;
            tail = tail.next;
        }
        flag = !flag;
        count++;
    }

    public int popFront() {
        int res = -1;
        if(count == 0){
            return res;
        }else if(count == 1){
            res = head.val;
            head = mid = tail = null;
        }else{
            if(flag){
                mid = mid.next;
            }
            res = head.val;
            head = head.next;
            head.pre.next = null;
            head.pre = null;
        }
        flag = !flag;
        count--;
        return res;
    }

    public int popMiddle() {
        int res = -1;
        if(count == 0){
            return res;
        }else if(count == 1){
            res = head.val;
            head = mid = tail = null;
        }else if(count == 2){
            res = head.val;
            head.next = null;
            tail.pre = null;
            head = mid = tail;
        }else{
            res = mid.val;
            Node tmp = mid;
            if(flag){
                mid = mid.next;
                mid.pre = mid.pre.pre;
                mid.pre.next = mid;
            }else{
                mid = mid.pre;
                mid.next = mid.next.next;
                mid.next.pre = mid;
            }
            tmp.next = tmp.pre = null;
        }
        flag = !flag;
        count--;
        return res;
    }

    public int popBack() {
        int res = -1;
        if(count == 0){
            return res;
        }else if(count == 1){
            res = head.val;
            head = mid = tail = null;
        }else{
            res = tail.val;
            tail = tail.pre;
            tail.next.pre = null;
            tail.next = null;
            if(!flag){
                mid = mid.pre;
            }
        }
        flag = !flag;
        count--;
        return res;
    }
}
