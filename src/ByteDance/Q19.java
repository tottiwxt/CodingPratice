package ByteDance;


/**
 * @Description: 2个线程并发打印1-100
 * @Author: wangxutao@qiyi.com
 * @Date: 7/11/21 2:52 AM
 */
public class Q19 {

  private static volatile int num = 1;


}

class PrintOdd implements Runnable{
  Num num;
  public PrintOdd(Num num) {
    this.num = num;
  }

  @Override
  public void run() {
    while(num.i<=100) {
      // 锁住该对象
      synchronized (num) {
        // 判断当前线程是否执行
        if(num.flag) {
          try {
            num.wait();
          }catch(InterruptedException e) {
            System.out.println(e.getMessage());
          }
        }else {
          System.out.println(Thread.currentThread().getName()+num.i);
          num.i++;
          num.flag = true;
          // 唤醒
          num.notify();
        }

      }
    }

  }
}

class PrintEven implements Runnable{
  Num num;
  public PrintEven(Num num) {
    this.num = num;
  }

  @Override
  public void run() {
    while(num.i<=100) {
      // 锁住该对象
      synchronized (num) {
        // 判断当前线程是否执行
        if(!num.flag) {
          try {
            num.wait();
          }catch(InterruptedException e) {
            System.out.println(e.getMessage());
          }
        } else {
          System.out.println(Thread.currentThread().getName()+num.i);
          num.i++;
          num.flag = false;
          // 唤醒
          num.notify();
        }

      }
    }

  }
}


class Num{
  int i = 1;
  // 标识
  boolean flag = false;
  public Num() {

  }
}
class Printer{
  int num = 1;
  public void increase() {
    synchronized (this) {
      while (num <= 100) {
        System.out.println(Thread.currentThread().getName() + " : " + num++);
        notify();
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

 class Print_Odd_Even {

  public static void main2(String[] args) {
    Num num = new Num();

    PrintOdd printOdd = new PrintOdd(num);
    PrintEven printEven = new PrintEven(num);

    Thread thread1 = new Thread(printOdd);
    Thread thread2 = new Thread(printEven);

    thread1.setName("奇数线程:");
    thread2.setName("偶数线程:");
    thread1.start();
    thread2.start();
  }

   public static void main(String[] args) {
     Printer printer = new Printer();
     Thread t1 = new Thread(() -> {
       printer.increase();;
     });
     Thread t2 = new Thread(() -> {
       printer.increase();;
     });
     t1.start();
     t2.start();
   }
}