package thread.threadsecurity;

/**
 * 通过加synchronized使方法同步，进而线程安全
 */
public class ThreadSecurity {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest2 threadTest2 = new ThreadTest2();
        new Thread(threadTest2).start();
        new Thread(threadTest2).start();
        new Thread(threadTest2).start();
    }
}

class ThreadTest2 implements Runnable {
    private int res = 100;
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            counter();
        }
    }

    private synchronized void counter(){
        if(res <= 0){
            loop = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + " run once and res = " + (--res));
                try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
