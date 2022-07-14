package thread.practice;

/**
 * 两个线程轮流打印1-100
 */
public class PrintNumberWithTwoThread {
    public static final Object lock = new Object();
    public static volatile int counter = 1;
    public static final int maxCounter = 100;
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized(lock){
                    while(counter <= maxCounter){
                        if(counter % 2 != 0){
                            System.out.println(Thread.currentThread().getName() + counter++);
                            lock.notify();
                        }else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        t1.setName("t1: ");
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized(lock){
                    while(counter <= maxCounter){
                        if(counter % 2 == 0){
                            System.out.println(Thread.currentThread().getName() + counter++);
                            lock.notify();
                        }else{
                            try{
                                lock.wait();
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        t2.setName("t2: ");
        t1.start();
        t2.start();
    }
}
