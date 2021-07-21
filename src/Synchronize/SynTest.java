package Synchronize;

public class SynTest implements Runnable {

  static int i = 0;

  public  void increase() {
    i++;
  }

  @Override
  public void run() {
    synchronized (this) {
      for (int count = 0; count < 2000; count++) {
        increase();
      }
    }
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
