package thread.threadsecurity;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest1 = new JoinTest();
        JoinTest joinTest2 = new JoinTest();
        Thread thread1 = new Thread(joinTest1);
        Thread thread2 = new Thread(joinTest2);
        thread1.start();
        thread2.start();
        while(joinTest1.getFlag() < 20){
        }
        thread2.join();
    }
}

class JoinTest implements Runnable {
    private int flag = 0;
    @Override
    public void run() {
        while(true && flag < 100){
            System.out.println(Thread.currentThread().getName() + " is running ! " + flag);
            flag++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getFlag() {
        return flag;
    }
}
