package lanqiao.java_2020;

public class Fraction {
    public static void main(String[] args) {
        int num = 0;
        for(int i = 1; i < 2021; i++){
            for (int j = 1; j < 2021; j++) {
                if(gcd(i, j) == 1){
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
