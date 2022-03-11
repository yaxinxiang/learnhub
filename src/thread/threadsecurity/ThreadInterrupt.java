package thread.threadsecurity;

/**
 * 中断睡眠操作
 */
public class ThreadInterrupt {
    public static void main(String[] args) {
        InterruptTest interruptTest = new InterruptTest();
        Thread thread = new Thread(interruptTest);
        thread.setName("InterruptTest");
        thread.start();
        while(true){
            try {
                Thread.sleep(5000);
                System.out.println(thread.getName() + " will be interrupted !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        }

    }
}

class InterruptTest implements Runnable {

    @Override
    public void run() {
        while(true){
            try{
                System.out.println(Thread.currentThread().getName() + " is running !");
                Thread.sleep(20000);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + " is Interrupted");
            }
        }
    }
}