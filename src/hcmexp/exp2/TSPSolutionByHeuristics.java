package hcmexp.exp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yaxin
 * @date 2022/5/24 18:17
 * 启发式搜索解决TSP问题
 */
public class TSPSolutionByHeuristics {
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private final int nodeCount;
    private final int[][] graph; //图
    private int[][] mst; //最小生成树
    private int[] degree; //最小生成树节点的度
    private int[] flag; //连通标记，不同的连通分量用不同的数字标记
    private int flag_1 = 0;
    private int minPathLen = MAX_VALUE;

    public TSPSolutionByHeuristics(int nodeCount, int sideCount){
        this.nodeCount = nodeCount;
        this.graph = new int[nodeCount + 1][nodeCount + 1];
        setGraph(sideCount);
    }

    /**
     * 解决TSP问题：
     */
    public void figureTSP(){
        //从每个点开始生成最小生成树
        for (int i = 1; i <= nodeCount; i++) {
            System.out.println("==================以"+ i +"为起点构造最小生成树==================");
            //生成最小生成树
            setMst(i);
            //生成之后处理度超过2的点然后连接处理度小于2的节点
            modifyMst();
            //输出连通回路
            printResult(i);
        }
        //打印最后结果：
        System.out.println("==================综上==================");
        System.out.println("该TSP问题的最小路径长度为" + minPathLen);
    }

    /**
     * 生成无向图
     * @param sideCount 边数
     */
    private void setGraph(int sideCount){
        for (int i = 1; i <= nodeCount; i++) {
            Arrays.fill(graph[i], MAX_VALUE);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入边与权重（如 1 2 3表示点1与点2之间的边权重为3）：");
        for (int i = 0; i < sideCount; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), value = sc.nextInt();
            graph[x][y] = value; graph[y][x] = value;
        }
        sc.close();
    }

    /**
     * 从点startIndex开始生成最小生成树
     * 边以及权重存储在mst（无向）中
     * 点的度存储在degree中
     * @param startIndex 起点
     */
    private void setMst(int startIndex){
        mst = new int[nodeCount + 1][nodeCount + 1];
        degree = new int[nodeCount + 1];
        flag = new int[nodeCount + 1];
        flag_1 = 0;
        int[] lowValue = new int[nodeCount + 1]; // 存储以i为终点的边的所有权值
        int[] head = new int[nodeCount + 1]; //存储 i 的起点

        for (int i = 1; i <= nodeCount; i++) {
            if(i == startIndex){
                continue;
            }
            lowValue[i] = graph[startIndex][i]; // 存放起始点startIndex可达点的路径长度
            head[i] = startIndex;
        }
        lowValue[startIndex] = 0; head[startIndex] = 0;

        for (int i = 1; i <= nodeCount; i++) {
            if(i == startIndex){
                continue;
            }
            int minValue = MAX_VALUE, minIndex = 0;
            for (int j = 1; j <= nodeCount; j++) {
                if(j == startIndex){
                    continue;
                }
                if(lowValue[j] < minValue && lowValue[j] != 0){
                    minValue = lowValue[j]; minIndex = j;
                }
            }
            System.out.printf("V%d-V%d=%d\n",head[minIndex],minIndex,minValue);
            mst[head[minIndex]][minIndex] = minValue; //记录最小生成树的边以及权重
            mst[minIndex][head[minIndex]] = minValue;
            degree[head[minIndex]] += 1; degree[minIndex] += 1; //记录点的度
            lowValue[minIndex] = 0;
            for(int j = 1; j <= nodeCount; j++){
                if(j == startIndex){
                    continue;
                }
                if(graph[minIndex][j] < lowValue[j]){
                    lowValue[j] = graph[minIndex][j];
                    head[j] = minIndex;
                }
            }
        }
        System.out.println("初始mstInfo：");
        printMstInfo();
    }

    /**
     * 处理度不等于2的点
     */
    private void modifyMst(){
        //处理度超过2的点
        for (int i = 1; i <= nodeCount; i++) {
            if(degree[i] > 2){
                while(degree[i] > 2){
                    int j = findMaxDegreeOrMaxValueIndex(i);
                    System.out.println("要删除的边为" + i + "-" + j);
                    deleteEdge(i, j);
                }
            }
        }
        //处理得到连通分量flag
        searchConnected();
        System.out.println("处理度超过2的点,并处理连通分量后的结果：");
        printMstInfo();
        //合并各连通分量（通过连接各连通分量中度小于2的点）
        connectAll();
        System.out.println("处理度小于2的节点，并处理连通分量后的结果：");
        printMstInfo();
        System.out.println(Arrays.toString(flag));
    }

    /**
     * 输出回路
     * @param startIndex 起点
     */
    private void printResult(int startIndex){
        int res = 0;
        int st = startIndex, nextIndex = -1;
        boolean[] vis = new boolean[nodeCount + 1];
        System.out.println("输出本次连通回路：");
        do{
            for (int i = 1; i <= nodeCount; i++) {
                if(i != st && !vis[i] && mst[st][i] > 0 && mst[st][i] < MAX_VALUE){
                    nextIndex = i;
                    vis[i] = true;
                    deleteEdge(st, i);
                    break;
                }
            }
            System.out.println(st + "->" + nextIndex + " " + graph[st][nextIndex]);
            res += graph[st][nextIndex];
            st = nextIndex;
        }while (st != startIndex);
        System.out.println("本次回路路径长度："+ res);
        if(res < minPathLen){
            minPathLen = res;
        }
    }

    /**
     * 先找与index点相连度大于2的点返回，若没有返回权值最大的点
     * @param index 待处理节点
     * @return 被选择的节点
     */
    private int findMaxDegreeOrMaxValueIndex(int index){
        int resIndex = -1, maxDegree = 0;
        for (int i = 1; i <= nodeCount; i++) {
            //选择相连的点
            if(i != index && mst[i][index] > 0){
                if(degree[i] > 2){
                    return i;
                }else{
                    if(mst[i][index] > maxDegree){
                        resIndex = i;
                        maxDegree = mst[i][index];
                    }
                }
            }
        }
        return resIndex;
    }

    /**
     * 删除最小生成树中的边
     * @param i 节点i
     * @param j 节点j
     */
    private void deleteEdge(int i, int j){
        mst[i][j] = 0; mst[j][i] = 0; //已经规定mst[i][j] == 0 表示边不存在
        degree[i]--; degree[j]--;
    }

    /**
     * 添加边至最小生成树中修改mst、degree
     * @param i 节点i
     * @param j 节点j
     */
    private void addEdge(int i, int j){
        mst[i][j] = graph[i][j]; mst[j][i] = graph[j][i];
        degree[i]++; degree[j]++;
    }

    /**
     * 搜索mst中的连通分量并使用flag标记
     */
    private void searchConnected(){
        int[][] copyMst = getCopyMst();
        int tag = 1;
        //搜索有边的连通分量
        for (int i = 1; i <= nodeCount; i++) {
            List<Integer> connected = new ArrayList<>();
            for (int j = i + 1; j <= nodeCount; j++) {
                if(copyMst[i][j] > 0){
                    connected.add(j);
                }
            }
            if(!connected.isEmpty()){
                mark(tag++, copyMst, i, connected);
            }
        }
        //添加单点连通分量
        for (int i = 1; i <= nodeCount; i++) {
            if(degree[i] == 0){
                flag[i] = tag++;
            }
        }
    }

    /**
     *选择不同连通分量中度小于 2 的节点并且两点之间权值小的点进行连接 ,从而构成一个大的连通分量 ,
     *最后连接同一个连通分量中仅有的两个度为 1 的节点 , 从而构成一个闭合回路 。
     */
    private void connectAll(){
        //先连接不同分量(这里默认连接到连通分量1中)：
        //思路找到连通分量1中所有度小于2的节点，与所有其他不属于连通分量1且度小于2的节点，连接权值最小的边，知道flag_1==nodeCount
        while(flag_1 < nodeCount){
            List<Integer> nodes1 = new ArrayList<>();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 1; i <= nodeCount; i++) {
                if(degree[i] < 2){
                    if(flag[i] == 1){
                        nodes1.add(i);
                    }else{
                        nodes.add(i);
                    }
                }
            }
            connectMinEdge(nodes1, nodes);
            countFlag_1();
        }

        //连接唯一分量中仅有的度为1的两个点(如果到这一步出现2个以上分量或2个以上点为1则之前的算法出现问题需要修改！)
        for (int i = 0; i <= nodeCount; i++) {
            if(degree[i] == 1){
                for (int j = i + 1; j <= nodeCount; j++) {
                    if (degree[j] == 1){
                        addEdge(i, j);
                    }
                }
            }
        }
    }

    /**
     * 记录第一连通分量的节点树
     */
    private void countFlag_1(){
        flag_1 = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if(flag[i] == 1){
                flag_1++;
            }
        }
    }

    /**
     * 找到最小一条边相连(修改mst、degree、flag)
     * @param nodes1 在连通分量1中度小于2的节点
     * @param nodes 在其他连通分量中小于2的节点
     */
    private void connectMinEdge(List<Integer> nodes1, List<Integer> nodes){
        int i = -1, j = -1, minValue = MAX_VALUE;
        for(Integer node1 : nodes1){
            for (Integer node2 : nodes){
                if(graph[node1][node2] == MAX_VALUE){
                    continue;
                }
                if(graph[node1][node2] < minValue){
                    i = node1; j = node2;
                    minValue = graph[node1][node2];
                }
            }
        }
        if(i != -1){
            //连接（修改mst、degree、flag）
            addEdge(i, j);
            //flag:
            int f = flag[j];
            for (int k = 1; k <= nodeCount; k++) {
                if(flag[k] == f){
                    flag[k] = flag[i]; // flag[i]就是1
                }
            }
        }
    }

    /**
     * 对一个连通分量进行标记
     */
    private void mark(int tag, int[][] copyMst, int i, List<Integer> connected){
        flag[i] = tag;
        for (Integer j : connected){
            flag[j] = tag;
            copyMst[i][j] = 0; copyMst[j][i] = 0;//已经标记的边要去掉
        }
        for (Integer j : connected){
            List<Integer> newConnected = new ArrayList<>();
            for (int k = j + 1; k <= nodeCount; k++) {
                if(copyMst[j][k] > 0){
                    newConnected.add(k);
                }
            }
            if(!newConnected.isEmpty()){
                mark(tag, copyMst, j, newConnected);
            }
        }
    }

    /**
     * 打印mst以及各点的度
     */
    public void printMstInfo(){
        System.out.println("最小生成树mst:");
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                System.out.print(mst[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("度degree:");
        for (int i = 1; i <= nodeCount; i++) {
            System.out.print(degree[i] + " ");
        }
        System.out.println();
        System.out.println("连通分量flag：");
        for (int i = 1; i <= nodeCount; i++) {
            System.out.print(flag[i] + " ");
        }
        System.out.println();
    }

    public int[][] getCopyMst(){
        int[][] copyMst = new int[mst.length][mst[0].length];
        for (int i = 0; i < mst.length; i++) {
            copyMst[i] = Arrays.copyOf(mst[i], mst[i].length);
        }
        return copyMst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数字分别表示无向图的顶点个数与边的个数：");
        TSPSolutionByHeuristics tspSolution = new TSPSolutionByHeuristics(sc.nextInt(), sc.nextInt());
        tspSolution.figureTSP();
    }
}
/*
案例：
4 6
1 2 1
1 4 2
1 3 3
2 3 4
2 4 6
3 4 5

5 10
1 2 3
1 3 1
1 4 5
1 5 8
2 3 6
2 4 7
2 5 9
3 4 4
3 5 2
4 5 3
 */