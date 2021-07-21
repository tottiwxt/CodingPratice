package Synchronize;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 2020-01-04 15:16
 */
public class ThreadExperiment implements Runnable{
  private  int i = 0;
  private synchronized  void add(){

      i++;

  }

  @Override
  public  void run(){
    for(int i = 0; i<1000;i++){
      add();
    }
  }


  public static void main(String[] args) {
//    Thread myThread1 = new Thread(new MyThread());
//    Thread myThread2 = new Thread(new MyThread());
//
//    myThread1.start();
//    myThread2.start();
//    try{
//      myThread1.join();
//      myThread2.join();
//      System.out.println(MyThread.i);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
    MyThread myThread1 = new MyThread();
    MyThread myThread2 = new MyThread();
    myThread1.print();
    myThread1.print();
    myThread1.print();
//    System.out.println(myThread1.getI());
    System.out.println(myThread2.getI());

  }
}
