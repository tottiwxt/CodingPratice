package Producer_Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
//有问题
public class BlockingQueue_test {
    final BlockingQueue bread = new ArrayBlockingQueue<>(10);
    private static int count = 0;

    class Producer implements Runnable{
        @Override
        public void run(){
            for(int i = 0 ; i<10; i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    bread.put(1);
                    count++;
                    System.out.println("producer "+Thread.currentThread().getName() + "produce, there're "+ (count));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    private class Consumer implements Runnable{
        @Override
        public void run(){
            for(int i=0 ; i<10 ; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    bread.take();
                    count --;
                    System.out.println("comsumer "+Thread.currentThread().getName() + "comsume, there're "+ (count));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
       BlockingQueue_test bt = new BlockingQueue_test();
        new Thread(bt.new Producer()).start();
        new Thread(bt.new Consumer()).start();
        new Thread(bt.new Producer()).start();
        new Thread(bt.new Consumer()).start();
        new Thread(bt.new Producer()).start();
        new Thread(bt.new Consumer()).start();
        new Thread(bt.new Producer()).start();
        new Thread(bt.new Consumer()).start();
    }

}
