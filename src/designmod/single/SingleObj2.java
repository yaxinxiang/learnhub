package designmod.single;

/**
 * 单例模式饿汉式写法
 */
public class SingleObj2 {
    private static SingleObj2 singleObj2 = new SingleObj2();

    private SingleObj2(){
    }

    public static SingleObj2 getInstance(){
        return singleObj2;
    }
}
