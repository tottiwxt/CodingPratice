package Synchronize;

public class SynTest implements Runnable {
    static  int i = 0;
    private int ticket = 1000;
    public void increase(){
        i++;
    }
    @Override
    public void run() {
        int count = 0;
        for(int i = 0;i<2000;i++){
            if(ticket>0){
                ticket--;
                count++;
                System.out.println("left  "+ ticket);
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest s = new SynTest();
        SynTest s2 = new SynTest();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
