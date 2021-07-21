package ByteDance;

/**
 * @Description: sqrt(),¶þ·Ö
 * https://leetcode-cn.com/problems/sqrtx/description/
 * @Author: wangxutao@qiyi.com
 * @Date: 7/20/21 10:46 AM
 */
public class Q24 {
  public static int mySqrt(int x) {
    int start = 0; int end = x;
    while (start <= end) {
      int mid = start + (end - start)/2;
      int res = mid * mid;
      if (res == x) {
        return mid;
      } else if (res < x) {
          start = mid + 1;
      } else if (res > x) {
          end = mid - 1;
      }
    }
    return end;
  }

  public static void main(String[] args) {
    System.out.println(mySqrt(2));
    System.out.println(mySqrt(4));
    System.out.println(mySqrt(5));
    System.out.println(mySqrt(6));
    System.out.println(mySqrt(7));
    System.out.println(mySqrt(8));
    System.out.println(mySqrt(9));
    System.out.println(mySqrt(121));
    System.out.println(mySqrt(120));
    System.out.println(mySqrt(1));
  }

  public static int mySqrt2(int x) {
    int left = 0, right = x / 2 + 1;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (mid * mid == x) {
        return (int) mid;
      } else if (mid * mid < x) {
        left = (int) (mid + 1);
      } else {
        right = (int) (mid - 1);
      }
    }
    return right;
  }
}
