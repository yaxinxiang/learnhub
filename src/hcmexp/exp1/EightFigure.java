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

    /**
     * 搜索入口
     * @param s0 起始状态
     * @param target 目标状态
     */
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

    /**搜索算法
     * @param list 待搜索节点集合
     */
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

    /**
     * 打印求解路径
     * @param target 目标节点
     */
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

    /**
     * 将八数码排列转换成八数码数组
     * @param s 源八数码排列
     * @return arr
     */
    public static int[][] input(String s) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < s.length(); i++) {
            arr[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return arr;
    }
}
