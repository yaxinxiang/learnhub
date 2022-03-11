package lanqiao.practice;

public class Fraction {
    public static void main(String[] args) {
        int up = 1, down = 1;
        for (int i = 0; i < 20; i++) {
            int tmpDown = (int)Math.pow(2, i);
        }
    }

    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}
