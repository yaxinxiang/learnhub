package hcmexp.exp1;

/**
 * @author Yaxin
 * @date 2022/5/20 12:57
 */
public class Node {
    public int[][] a;
    int x, y; //存储
    public int sum = 0;
    public Node[] nodes; // 0 存储父节点 1-4存储子节点

    public Node(int[][] s0) {
        a = s0;
        find0(s0);
        nodes = new Node[5];
        sum = Node.getSum(this);
    }

    /**
     * 根据目前八数码数组节点的状态推出之后可能的几种状态
     */
    public void setUDLR() {
        if (a == null) {
            return;
        }
        int[][] pos = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int x1 = x + pos[i][0], y1 = y + pos[i][1];
            if (x1 < 0 || x1 >= 3 || y1 < 0 || y1 >= 3) {
                nodes[i + 1] = null;
            } else {
                Node child = new Node(getCopyAndChanged(x1, y1, x, y, a));
                child.nodes[0] = this;
                nodes[i + 1] = child;
            }
        }
    }

    /**
     * 寻找并记录空位
     * @param a 八数码数组
     */
    private void find0(int[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    this.x = i;
                    this.y = j;
                }
            }
        }
    }

    /**
     * 复制数组并交换空位置与某个相邻数，
     * 生成一个子节点的八数码状态数组
     * @param x1 x1
     * @param y1 y1
     * @param x x
     * @param y y
     * @param s0 原数组
     * @return 新数组
     */
    private static int[][] getCopyAndChanged(int x1, int y1, int x, int y, int[][] s0) {
        int[][] res = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = s0[i][j];
            }
        }
        int tmp = res[x1][y1];
        res[x1][y1] = 0;
        res[x][y] = tmp;
        return res;
    }

    /**
     * 判断两数组内容是否相等
     * @param a 原数组
     * @param target 目标数组
     * @return
     */
    public static boolean isEqual(int[][] a, int[][] target) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 打印 本次node状态
     * @param node 存储八数码状态的节点
     */
    public static void printA(Node node) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(node.a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 判断两个状态是否可达
     * @param s0 初始状态
     * @param target 目标状态
     * @return true or false
     */
    public static boolean canFigure(int[][] s0, int[][] target) {
        return getPermutation(s0) % 2 == getPermutation(target) % 2;
    }

    /**
     * 获取排列数
     * @param a 原排列
     * @return 排列数
     */
    public static int getPermutation(int[][] a) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            int tmp = a[i / 3][i % 3];
            if (tmp == 0) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (tmp < a[j / 3][j % 3]) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int getSum(Node node){
        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res = res * 10 + node.a[i][j];
            }
        }
        return res;
    }
}
