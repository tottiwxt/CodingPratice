package Synchronize;

public class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            print(i);
        }
    }
    public synchronized void print(int i){
        System.out.println(Thread.currentThread().getName()+" " + i);
    }

}
