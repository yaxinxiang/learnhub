package designpatterns.ceratepatterns.singleton;

/**
 * 单例模式
 * 饿汉式写法：在类加载时完成实例化
 */
public class SingleObj2 {
    private static SingleObj2 singleObj2 = new SingleObj2();

    private SingleObj2(){
    }

    public static SingleObj2 getInstance(){
        return singleObj2;
    }
}
