package lanqiao.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScholarShip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Score> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Score(i + 1, sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        list.sort((o1, o2) -> {
            if(o1.sum - o2.sum != 0){
                return o2.sum - o1.sum;
            }else if(o1.chinese - o2.chinese != 0){
                return o2.chinese - o1.chinese;
            }else{
                return o2.id - o1.id;
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i).id + " " + list.get(i).sum);
        }
        sc.close();
    }
}

class Score {
    int id;
    int chinese;
    int math;
    int english;
    int sum;

    public Score(int id, int chinese, int math, int english) {
        this.id = id;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.sum = chinese + math + english;
    }
}
