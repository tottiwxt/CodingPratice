package ByteDance;

/**
 * @Description: 两个数组，使用线程交叉打印
 * @Author: wangxutao@qiyi.com
 * @Date: 7/20/21 9:07 PM
 */
public class Q27 {
  public static Object object = new Object();
  static class Printer implements Runnable{
    private int[] nums;
    Printer(int[] nums) {
      this.nums = nums;
    }
    @Override
    public void run() {
      synchronized (object) {
        for (int i = 0; i< nums.length; i++) {
          System.out.println(nums[i]);
          object.notify();
          try {
            object.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1,3,5,7,9};
    int[] nums2 = {2,4,6,8,10};
    Printer p1 = new Printer(nums1);
    Printer p2 = new Printer(nums2);
    Thread t1 = new Thread(p1);
    Thread t2 = new Thread(p2);
    t1.start();
    t2.start();

  }
}
