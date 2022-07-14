package thread.practice;

/**
 * 多个线程轮流打印1-100
 */
public class PrintNumberWithThree {
    public static final Object lock = new Object();
    public static void main(String[] args){
        Print100 t1 = new Print100(1);
        Print100 t2 = new Print100(2);
        Print100 t3 = new Print100(3);
        Print100 t4 = new Print100(0);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Print100 extends Thread{
    private static final Object lock = new Object();
    public static volatile int counter = 1;
    int n;
    public Print100(int n){
        this.n = n;
        int tmp = n == 0 ? 4 : n;
        this.setName("t" + tmp + ": ");
    }
    @Override
    public void run() {
        printCounter();
    }

    private void printCounter(){
        synchronized (lock){
            while(counter <= 100){
                if(counter % 4 == n){
                    System.out.println(Thread.currentThread().getName() + counter++);
                    lock.notifyAll();
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
}