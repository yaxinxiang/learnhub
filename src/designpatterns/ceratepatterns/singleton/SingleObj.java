package designpatterns.ceratepatterns.singleton;

/**
 * 单例模式
 * 懒汉式写法：第一次调用时创建实例（线程不安全）
 */
public class SingleObj {
    private static SingleObj singleObj;

    private SingleObj(){
    }

    /**
     * 这里是线程不安全的，可以在方法上面添加关键字synchronized使其线程安全，但效率降低
     * @return
     */
    public static SingleObj getInstance(){
        if(singleObj == null){
            singleObj = new SingleObj();
        }
        return singleObj;
    }
}
