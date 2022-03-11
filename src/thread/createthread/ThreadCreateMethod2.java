package thread.createthread;

/**
 * 实现Runnable接口，通过Thread代理执行
 * 该方法在本类必须要继承其他类不能直接继承Thread时使用
 * 适合多线程共享资源，避免单继承限制
 */
public class ThreadCreateMethod2 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("当前类： " + getClass().getName() + " 当前线程："+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCreateMethod2 thread2 = new ThreadCreateMethod2();
        Thread proxy = new Thread(thread2);
        proxy.start();
        while(true){
            System.out.println("当前类： " + Thread.currentThread().getClass().getName() + " 当前线程："+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
