package Producer_Consumer;

import Synchronize.Synchronized;

import java.util.function.Consumer;

public class Test {
    private static String LOCK = "lock";
    private static final int MAX = 10;
    private static int count = 0;
    private class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0 ; i<10; i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while(count>=MAX){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count ++;
                    System.out.println("producer " + Thread.currentThread().getName() +" produce, there're " + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
    private class Consumer implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i<10;i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK){
                    while(count<=0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count -- ;
                    System.out.println("Consumer "+Thread.currentThread().getName() + "consume, there're "+count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }
}
