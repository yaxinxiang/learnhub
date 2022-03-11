package thread.threadsecurity;

public class ThreadStop {
    public static void main(String[] args) {
        StopTest stopTest = new StopTest();
        Thread thread = new Thread(stopTest);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopTest.setRun(false);
        System.out.println(thread.getName() + " will stop!");
    }
}

class StopTest implements Runnable{
    private boolean run = true;

    @Override
    public void run() {
        while(run){
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
