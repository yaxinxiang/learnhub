package designmod.single;

/**
 * 单例模式懒汉式写法
 */
public class SingleObj {
    private static SingleObj singleObj;

    private SingleObj(){
    }

    public static SingleObj getInstance(){
        if(singleObj == null){
            singleObj = new SingleObj();
        }
        return singleObj;
    }
}
