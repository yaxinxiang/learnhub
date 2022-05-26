package lmytest.p2;

public class Calculator {
    private static int result; // 静态变量，用于存储运行结果
    public void add(int n) {
        result = result + n;
    }
    public void substract(int n) {
        result = result - n;
    }
    public int getResult() {
        return result;
    }
    public void clear() {     // 将结果清零
        result = 0;
    }
}
