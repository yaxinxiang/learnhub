package thread.createthread;

/**
 * 通过继承Thread创建线程,重写run方法(写自己的逻辑)
 * Thread实现Runnable接口
 */
public class ThreadCreateMethod1 extends Thread{
    @Override
    public void run() {
        try {
            while(true){
                System.out.println("A second past!" + " Now thread is:" + Thread.currentThread().getName());
                Thread.sleep(5000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadCreateMethod1 thread1 = new ThreadCreateMethod1();
        System.out.println("main线程名：" + Thread.currentThread().getName());
        thread1.start();
        while(true){
            System.out.println("main线程不会因为子线程的启动而阻塞！");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
