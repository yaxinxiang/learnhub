package hcmexp.exp3;

/**
 * @author Yaxin
 * @date 2022/6/5 8:32
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 遗传算法的结点（一个结点作为一个个体）
 */
class GN_Node {
    public String sol;  //存放路径
    public int value;  //存放该路径的距离代价

    public GN_Node(int num) {
        sol = "";
        value = Integer.MAX_VALUE;
    }
}

/**
 * 遗传算法 解决TSP问题
 * <p>
 * 由于遗传算法要求个体适应度大的易于繁殖，而TSP问题求的是最短路径，
 * 因此需要保证路径值最短的个体的适应度、选择概率、累积概率是相对大
 * 的，因此将个体的适应度 都减去相同的值（该值要足够大。大于所有可
 * 能计算出来的路径长度），再取绝对值。最后的最短路径结果，只需要
 * 使用该值，减去个体的适应度即可。
 */
public class Genetic_algorithms {
    private Map<String, Integer> population; //种群,使用map保存个体（individual），key为个体的基因片段，value为个体的评估值，这样可以保证个体的唯一，一个键值对表示一个个体
    private int[][] Dist;   //城市的距离矩阵
    private int city_num;//城市数量
    private float mutate;//个体变异率 （若概率小于该数，则变异个体）
    private int max = 3000; //最大值
    private String best_individual; //最优个体
    private int best_distance;  //最短路径长度
    private float Pc;
    private float Pm;
    private int iteration;


    /**
     * 初始化算法执行所需要的各个参数
     *
     * @param dist   城市距离矩阵
     * @param mutate 个体变异率
     * @param start  起点城市
     * @param num    初始化种群大小
     */
    public Genetic_algorithms(int[][] dist, float mutate, int start, int num, int iteration, float Pc, float Pm) {
        Dist = dist;
        population = new HashMap<>();
        city_num = Dist.length;
        this.mutate = mutate;
        this.iteration = iteration;
        this.Pc = Pc;
        this.Pm = Pm;
        init(start, num);
    }

    /**
     * 在当前种群中，选出适应度最大的作为最优解
     *
     * @return
     */
    public void select_Best() {
        Set<String> strings = population.keySet();

        for (String string : strings) {
            if (population.get(string) > best_distance) {
                best_individual = string;
                best_distance = population.get(string);
            }
        }
    }

    /**
     * 初始化初代种群
     *
     * @param start 起点城市
     * @param num   初代种群大小
     */
    public void init(int start, int num) {
        //生成含有10个不相同个体的初始种群
        int i = 0;
        Random random = new Random();//用于产生 0~city_num 之间的整数，作为城市编号
        do {
            String individual = "" + start;    //个体，保证个体基因不重复，TSP问题中，基因指城市编号

            for (int j = 1; j < city_num; j++) {
                int gen;

                do {
                    gen = random.nextInt(city_num);  //随机生成城市编号
                } while (isRepeat(individual, gen));//确保生成的基因不重复

                individual += gen;
            }

            if (!population.containsKey(individual)) {
                //若不包含该个体，则将其加入到map集合中
                //计算该个体的适应度
                int value = evaluate(individual);
                population.put(individual, value);

                //初始化最优解，将第一个个体作为最优解赋值给 best_individual 和 best_distance
                if (i == 0) {
                    best_individual = individual;
                    best_distance = value;
                }

                i++;
            }

        } while (i < num);

        System.out.println(population);
    }

    /**
     * 用于检查一个基因，在该基因个体基因上是否有重复
     *
     * @return
     */
    public boolean isRepeat(String individual, int gen) {
        for (int i = 0; i < individual.length(); i++) {
            if (individual.charAt(i) - '0' == gen)
                return true;
        }

        return false;
    }

    /**
     * 实现个体的变异，变异方式为：随机生成两个坐标，x、y x≠y 然后将x和y的基因对换
     *
     * @param individual
     */
    public String mutate(String individual) {
        Random random = new Random();
        int length = individual.length();
        int x, y;
        do {
            x = random.nextInt(length);
            y = random.nextInt(length);
        } while (!(x != 0 && y != 0 && x != y));

        char[] chars = individual.toCharArray();

        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;

        String mutate_individual = "";
        for (int i = 0; i < chars.length; i++) {
            mutate_individual += chars[i];
        }

        return mutate_individual;
    }

    /**
     * 根据传入的个体基因，计算该结点的适应度
     *
     * @param individual
     * @return
     */
    public int evaluate(String individual) {
        int distance = 0; //用距离代价作为该个体的适应度
        int x;
        int y;
        for (int i = 1; i < individual.length(); i++) {
            x = individual.charAt(i - 1) - '0';   //计算出城市编号
            y = individual.charAt(i) - '0';     //计算出城市编号

            distance = distance + Dist[x][y];
        }

        x = individual.charAt(city_num - 1) - '0';
        y = individual.charAt(0) - '0';
        distance = distance + Dist[x][y];

        return -(distance - max);//由于遗传算法要求个体适应度大的易于繁殖，而TSP问题求的是最短路径，因此给计算出来的距离代价加上-号，保证距离代价小的个体适应度大
    }

    /**
     * 在种群中随机选择个体进行繁殖
     *
     * @param population
     * @return
     */
    public String random_select(Map population) {
        int sum = 0;  //保存个体适应度总和，用于求个体的选择概率 选择概率=个体适应度/种群适应度总和
        Random random = new Random(); //用于生成随机选择概率
        Set<String> set = population.keySet();
        for (String s : set) {
            sum += (int) population.get(s);
        }

        for (String s : set) {
            double r = random.nextDouble();   //生成随机选择概率

            //若该个体的选择概率大于随机生成的选择概率，则将该个体作为选择出来的个体进行繁殖
            double value = ((double) ((int) population.get(s)) / sum);
//            System.out.println(r+","+value+","+(int)population.get(s));
            if (r < value) {
                return s;
            }
        }

        return null;
    }

    /**
     * 传入两个父辈个体，放回其后代
     *
     * @param x
     * @param y
     * @return
     */
    public String reproduce(String x, String y) {
        int n = x.length();
        Random random = new Random(); //用于生成随机的分割点，但是不能去0和n-1
        int index = 0;
        do {
            index = random.nextInt(n);
        } while (index > 0 && index < n - 1);

        return x.substring(0, index) + y.substring(index, n);   //返回后代
    }

    /**
     * 判断是否有重复基因
     *
     * @param individual
     * @return
     */
    public boolean isRepeat(String individual) {
        for (int i = 0; i < individual.length(); i++) {
            for (int j = i + 1; j < individual.length(); j++) {
                if (individual.charAt(i) == individual.charAt(j))
                    return true;
            }
        }
        return false;
    }

    /**
     * 遗传算法主函数
     */
    public void GN_main() {
        Random random = new Random();

        int num_iteration = 0;    //计数种群的迭代次数

        while (num_iteration < 5000) {
            Map<String, Integer> new_population = new HashMap<>(); //临时存放新产生的种群

            //每一次迭代，先在种群中选出最优best_individual
            select_Best();

            for (int i = 0; i < population.size(); i++) {
                //随机选择两个父个体
                String parent1;
                String parent2;
                do {
                    parent1 = random_select(population);
                } while (parent1 == null);

                do {
                    parent2 = random_select(population);
                } while (parent2 == null);

                //两个父个体产生一个子个体,确保子代没有重复的基因
                String child;
                do {
                    child = reproduce(parent1, parent2);
                } while (isRepeat(child));


                float r = random.nextFloat(); //随机产生一个0~1之间的数

                if (r < random.nextFloat()) {
                    child = mutate(child);
                }

                if (!new_population.containsKey(child)) {
                    int value = evaluate(child);
                    new_population.put(child, value);    //将子代加入种群
                }
            }

            //更新种群，将新产生的种群作为当前种群，继续进行下一代繁殖
            population = new_population;
            num_iteration++;
            System.out.println("当前迭代第" + num_iteration + "次。种族为：" + population);
        }
    }

    public String getBest_individual() {
        return best_individual;
    }

    public int getBest_distance() {
        return best_distance;
    }

    public Map<String, Integer> getPopulation() {
        return population;
    }

    public static void main(String[] args) {
        int max = 666;

        //距离矩阵
        int[][] Dist = {{max, 3, 2, 3, max}, {3, max, max, 6, 4}, {2, max, max, 1, 5}, {3, 6, 1, max, 7}, {max, 4, 5, 7, max}};
        float a = 0.9f;
        Genetic_algorithms sa = new Genetic_algorithms(Dist, a, 0, 10, 5000, 0.9f, 0.001f);
        sa.GN_main();

        System.out.println("最佳行驶路径:" + sa.getBest_individual() + ".最短路径:" + (3000 - sa.getBest_distance()));
    }
}
