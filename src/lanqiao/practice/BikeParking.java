package lanqiao.practice;

import java.util.Scanner;

public class BikeParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int firstNum = sc.nextInt();
        Node head = new Node();
        Node before = head;
        Node node = new Node(firstNum);
        head.next = node;
        int x, y ,z;
        for (int i = 0; i < n - 1; i++) {
            x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
            Node tmp = new Node(x);
            for(node = head.next; node != null; before = node, node = node.next){
                if(node.val == y){
                    break;
                }
            }
            if(z == 0){
                before.next = tmp;
                tmp.next = node;
            }else{
                tmp.next = node.next;
                node.next = tmp;
            }
        }
        while(head.next != null){
            head = head.next;
            System.out.print(head.val + " ");
        }
        sc.close();
    }
}

class Node{
    int val;
    Node next;
    public Node(){
    }
    public Node(int val){
        this.val = val;
    }
}