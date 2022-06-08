package hcmexp.exp3;

import java.util.*;

/**
 * @author Yaxin
 * @date 2022/5/29 8:24
 */
public class TSPSolutionByGA {
    List<Individual> individuals = new ArrayList<>();
    List<Map<Integer, Integer>> distance = new ArrayList<>();
    List<City> cities = new ArrayList<>();
    int cityCount;
    public double Ps; //选择率
    public double Pc; // 交叉率
    public double Pm; // 变异率
    int PcNum = 0; // 记录交叉次数
    int PmNum = 0; // 记录变异次数
    public int populationNum;
    public int maxIteration;
    public int bestDistance = Integer.MAX_VALUE;
    public String bestPath;
    Random random = new Random();

    public static void main(String[] args) {
        TSPSolutionByGA tspSolutionByGA = new TSPSolutionByGA(0.02,0.9, 0.001, 100, 200000);
        tspSolutionByGA.mainFunc();
    }

    /**
     * 初始化参数
     * @param Pc 交叉概率 0.9
     * @param Pm 变异概率 0.001
     * @param maxIteration 最大迭代次数
     * @param populationNum 种群规模 40
     */
    public TSPSolutionByGA(double Ps, double Pc, double Pm, int maxIteration, int populationNum) {
        this.Ps = Ps;
        this.Pc = Pc;
        this.Pm = Pm;
        this.maxIteration = maxIteration;
        this.populationNum = populationNum;
    }

    public void mainFunc(){
        //输入城市坐标处理数据
        inputCities();
        //初始化种群
        init();
        System.out.println("初始种群数量：" + individuals.size());
        int iteration = 0;//迭代次数
        while(iteration++ < maxIteration){
            System.out.println("迭代次数：" + iteration);
            //选择交叉变异
            newGeneration();
            //每次迭代选出最优路径：
            selectBest();
            System.out.println("截止当代最佳路径：" + bestPath);
            System.out.println("截止当代最小距离：" + bestDistance);
        }
        System.out.println("最佳路径：" + bestPath);
        System.out.println("最小距离：" + bestDistance);
        System.out.println("交叉次数：" + PcNum);
        System.out.println("变异次数：" + PmNum);
    }

    /**
     * 随机产生一个populationNum大的种群
     */
    private void init(){
        Set<String> population = new HashSet<>();
        // 种群初始化
        while (population.size() < populationNum) {
            //染色体
            int[] chromosome = new int[cityCount];
            boolean[] vis = new boolean[cityCount];
            for (int j = 0; j < cityCount; j++) {
                int gen;
                while(vis[(gen = random.nextInt(cityCount))]){
                }
                vis[gen] = true;
                chromosome[j] = gen;
            }
            Individual individual = new Individual(chromosome);
            setFitness(individual);
            if(population.add(individual.toString())){
                individuals.add(individual);
            }
        }
    }

    /**
     * 通过上一代生成新一代（选择交叉变异）
     */
    private void newGeneration(){
        List<Individual> newIndividuals = new ArrayList<>();
        Set<String> population = new HashSet<>();
        int count = 0, index1, index2;
        //随机选择亲代(排序选择,弱者淘汰)
        while(population.size() < populationNum){
            index1 = index2 = -1;
            while(index1 == index2){
                index1 = random.nextInt((int)(populationNum * Ps));
                index2 = random.nextInt((int)(populationNum * Ps));
            }
            Individual individual1 = individuals.get(index1);
            Individual individual2 = individuals.get(index2);
            //交叉
            double pc = random.nextDouble();
            int[] ch1, ch2;
            if(pc <= Pc){
                int p1 = -1, p2 = -1;
                while(p1 == p2){
                    p1 = random.nextInt(cityCount);
                    p2 = random.nextInt(cityCount);
                }
                if(p1 > p2){
                    int tmp = p1; p1 = p2; p2 = tmp;
                }
                ch1 = crossover(individual1.chromosome, individual2.chromosome, p1, p2);
                ch2 = crossover(individual2.chromosome, individual1.chromosome, p1, p2);
                //变异
                vary(ch1); vary(ch2);
                Individual newIndividual1 = new Individual(ch1);
                Individual newIndividual2 = new Individual(ch2);
                //放入新一代中并计算适应度：
                if(population.add(newIndividual1.toString())){
                    setFitness(newIndividual1);
                    newIndividuals.add(newIndividual1);
                }
                if(population.add(newIndividual2.toString())){
                    setFitness(newIndividual2);
                    newIndividuals.add(newIndividual2);
                }
            }
        }
        individuals = newIndividuals;
        individuals.sort((o1, o2) -> (int) (o1.fitness - o2.fitness));
    }

    /**
     * 交叉操作
     * @param chromosome1 染色体1
     * @param chromosome2 染色体2
     * @param pos1 交叉点1
     * @param pos2 交叉点2
     * @return 新染色体
     */
    public int[] crossover(int[] chromosome1, int[] chromosome2, int pos1, int pos2){
        PcNum++;
        boolean[] vis = new boolean[cityCount];
        int[] resChromosome = new int[cityCount];
        for(int i = pos1; i <= pos2; i++){
            resChromosome[i] = chromosome1[i];
            vis[chromosome1[i]] = true;
        }
        int pos = 0;
        for(int i = 0; i < cityCount; i++){
            if(pos == pos1){
                pos = pos2 + 1;
            }
            if(!vis[chromosome2[i]]){
                resChromosome[pos++] = chromosome2[i];
                vis[chromosome2[i]] = true;
            }
        }
        return resChromosome;
    }

    /**
     * 变异操作
     * @param chromosome 染色体
     */
    public void vary(int[] chromosome){
        double pm = random.nextInt(1000000) / 1000000.0;
        if(pm > Pm){
            return;
        }
        PmNum++;
        int p1 = -1, p2 = -1;
        while(p1 == p2){
            p1 = random.nextInt(cityCount);
            p2 = random.nextInt(cityCount);
        }
        int tmp = chromosome[p1]; chromosome[p1] = chromosome[p2]; chromosome[p2] = tmp;
    }

    /**
     * 记录本种群最小路径
     */
    private void selectBest(){
        Individual individual = individuals.get(0);
        if(bestDistance > individual.fitness){
            bestDistance = Math.min(bestDistance, individual.fitness);
            bestPath = individual.toString();
        }
    }

    /**
     * 输入城市坐标并计算坐标之间的距离
     */
    private void inputCities(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入城市个数，（如48）：");
        cityCount = sc.nextInt();
        for(int i = 0; i < cityCount; i++) {
            distance.add(new HashMap<>());
        }
        System.out.println("请依次输入这" + cityCount + "个城市的序号以及坐标（id x y），（如 1 2233 3322）：");
        for(int i = 0; i < cityCount; i++){
            City city = new City(sc.nextInt() - 1, sc.nextInt(), sc.nextInt()); //输入时将城市id-1做索引使用
            cities.add(city);
            for (int j = 0; j < i; j++) {
                City preCity = cities.get(j);
                int d = setDistance(city, preCity);
                distance.get(preCity.id).put(city.id, d);
                distance.get(city.id).put(preCity.id, d);
            }
        }
    }

    /**
     * 计算距离
     * @param city1 城市1
     * @param city2 城市2
     * @return distance
     */
    private static int setDistance(City city1, City city2){
        int absX = Math.abs(city1.x - city2.x);
        int absY = Math.abs(city1.y - city2.y);
        return (int)Math.sqrt(absX * absX + absY * absY);
    }

    /**
     * 获取两城市之间的距离
     * @param id1 城市1
     * @param id2 城市2
     * @return distance
     */
    private int getDistance(int id1, int id2){
        return  distance.get(id1).get(id2);
    }

    /**
     * 计算适应度函数
     * @param individual 个体
     */
    private void setFitness(Individual individual){
        int[] ch = individual.chromosome;
        int tmp = 0;
        for(int i = 0; i < individual.chromosome.length - 1; i++){
            tmp += getDistance(ch[i], ch[i + 1]);
        }
        tmp += getDistance(ch[0], ch[ch.length - 1]);
        individual.fitness = tmp;
    }


}

/**
 * 个体
 */
class Individual {
    public int[] chromosome;
    public int fitness;
    Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j : chromosome) {
            sb.append(j + 1); // 将序号转换为城市id
            sb.append(" ");
        }
        return sb.toString();
    }
}

class City {
    final int id;
    final int x;
    final int y;

    public City(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
}