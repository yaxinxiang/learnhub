package thread.threadsecurity;

/**
 * 线程不安全示例：
 */
public class ThreadInsecurity {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
    }
}

class ThreadTest implements Runnable {
    public int res = 100;
    @Override
    public void run() {
        while(true){
            if(res <= 0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run once and res = " + (--res));
        }
    }
}
