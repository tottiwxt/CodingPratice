package Synchronize;

public class MyThread implements Runnable {
    public static int i = 0;
    public int count = -1;
//    private synchronized  void add(){
//
//        i++;
//
//    }

    public int getI() {
        return i;
    }

    @Override
    public void run(){
        for (int j = 0; j < 10000; j++) {
            print();
        }
    }
    public  void print(){
//        synchronized(i){
            i ++;
            System.out.println(Thread.currentThread().getName()+" " + i);
//        }
    }

}
