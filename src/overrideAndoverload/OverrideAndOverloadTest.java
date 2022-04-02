package overrideAndoverload;

/**
 * 方法的重写与重载
 * 重写：方法的参数类型与返回类型不能修改，只能修改方法的逻辑
 * 重载：方法的参数类型必须修改 返回类型可以修改
 */
public class OverrideAndOverloadTest {
    public int getSum(int a, int b) {
        return a + b;
    }

    /*
    重载
     */
    public float getSum(float a, float b) {
        return a + b;
    }
}

class SonObject extends OverrideAndOverloadTest {
    int c = 0;

    /*
    重载
    在子类重载父类的getSum方法
     */
    public double getSum(double a, double b) {
        return a + b;
    }

    /*
    重载
    父类的int类型的getSum方法
     */
    public int getSum(int a, int b, int c) {
        return a + b + c;
    }

    /*
    重写
    在子类中重写父类的int类型的getSUm方法
     */
    public int getSum(int a, int b) {
        return a + b + c;
    }
}
