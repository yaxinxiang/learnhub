package hcmexp.exp1;

/**
 * @author Yaxin
 * @date 2022/5/20 12:57
 */
public class Node {
    public int[][] a;
    int x, y;
    public Node[] nodes;

    public Node(int[][] s0) {
        a = s0;
        find0(s0);
        nodes = new Node[5];
    }

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

    public void find0(int[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    this.x = i;
                    this.y = j;
                }
            }
        }
    }

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

    public static void printA(Node node) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(node.a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean canFigure(int[][] s0, int[][] target) {
        return getInversionNumber(s0) % 2 == getInversionNumber(target) % 2;
    }

    public static int getInversionNumber(int[][] a) {
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
}
