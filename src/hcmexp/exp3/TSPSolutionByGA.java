package hcmexp.exp3;

import java.util.*;
/**
 * @author Yaxin
 * @date 2022/5/29 8:24
 */
public class TSPSolutionByGA {
    Map<String, Double> population;
    List<Map<Integer, Double>> distance = new ArrayList<>();
    List<City> cities = new ArrayList<>();
    int cityCount;
    public double Pc; // 0.9
    public double Pm; // 0.001
    public int populationNum;
    public int maxIteration;
    public double bestDistance;
    Random random = new Random();

    /**
     * 初始化参数
     * @param Pc
     * @param Pm
     * @param maxIteration
     */
    public TSPSolutionByGA(double Pc, double Pm, int maxIteration, int populationNum) {
        this.Pc = Pc;
        this.Pm = Pm;
        this.maxIteration = maxIteration;
        this.populationNum = populationNum;
        this.population = new HashMap<>();
    }

    public void mainFunc(){
        //输入城市坐标处理数据
        inputCities();
        //初始化种群
        init();
        int iteration = 0;
        while(iteration < maxIteration){
            Map<String, Double> newPopulation = new HashMap<>();
            //每次迭代选出最优路径：
            selectBest();

        }
    }

    private void init(){
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
            population.put(individual.toString(), individual.fitness);
        }
    }

    /**
     * 本种群最小路径
     */
    private void selectBest(){
        for(String path : population.keySet()){
            bestDistance = Math.min(bestDistance, population.get(path));
        }
    }

    /**
     * 输入城市坐标计算坐标之间的距离
     */
    private void inputCities(){
        Scanner sc = new Scanner(System.in);
        cityCount = sc.nextInt();
        for(int i = 0; i < cityCount; i++){
            distance.add(new HashMap<>());
            City city = new City(sc.nextInt(), sc.nextInt(), sc.nextInt());
            cities.add(city);
            for (int j = 0; j < i; j++) {
                double d = setDistance(city, cities.get(j));
                distance.get(j).put(i, d);
                distance.get(i).put(j, d);
            }
        }
    }

    /**
     * 计算距离
     * @param city1 城市1
     * @param city2 城市2
     * @return distance
     */
    private static double setDistance(City city1, City city2){
        double absX = Math.abs(city1.x - city2.x);
        double absY = Math.abs(city1.y - city2.y);
        return Math.sqrt(absX * absX + absY * absY);
    }

    /**
     * 获取两城市之间的距离
     * @param id1 城市1
     * @param id2 城市2
     * @return distance
     */
    private double getDistance(int id1, int id2){
        return  distance.get(id1).get(id2);
    }

    /**
     * 适应度函数
     * @param individual 个体
     */
    private void setFitness(Individual individual){
        int[] ch = individual.chromosome;
        double tmp = 0;
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
    public final int[] chromosome;
    public double fitness;
    Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chromosome.length; i++) {
            sb.append(chromosome[i]);
        }
        return sb.toString();
    }
}

class City {
    final int id;
    final double x;
    final double y;

    public City(int id, double x, double y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
}