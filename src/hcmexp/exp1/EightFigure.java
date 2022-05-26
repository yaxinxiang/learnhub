package hcmexp.exp1;

import java.util.*;

/**
 * @author Yaxin
 * @date 2022/5/20 13:03
 */
public class EightFigure {
    Node target;
    int[][] tar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] s0 = input(sc.next());
        int[][] target = input(sc.next());
        new EightFigure().search(s0, target);
    }

    public void search(int[][] s0, int[][] target) {
        tar = target;
        if (s0 == null || target == null || !Node.canFigure(s0, target)) {
            System.out.println("no solution!");
            return;
        }
        List<Node> list = new ArrayList<>(Collections.singletonList(new Node(s0)));
        doSearch(list);
        printPath(this.target);
    }

    public void doSearch(List<Node> list) {
        System.out.println("searching!");
        if (list.size() == 0) {
            return;
        }
        ArrayList<Node> newList = new ArrayList<>();
        for (Node node : list) {
            if (Node.isEqual(node.a, tar)) {
                target = node;
                System.out.println("find it!");
                return;
            }
            node.setUDLR();
            for (int i = 1; i <= 4; i++) {
                if (node.nodes[i] != null)
                    newList.add(node.nodes[i]);
            }
        }
        doSearch(newList);
    }

    public void printPath(Node target) {
        Deque<Node> queue = new LinkedList<>();
        while (target != null) {
            queue.push(target);
            target = target.nodes[0];
        }
        while (!queue.isEmpty()) {
            Node.printA(queue.pop());
        }
    }

    public static int[][] input(String s) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < s.length(); i++) {
            arr[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return arr;
    }
}
