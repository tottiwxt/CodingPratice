package ByteDance;

import java.util.Random;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 7/10/21 4:48 PM
 */
public class Q16 {
  private static int[] quickSort(int[] num, int start, int end) {
    if (start >= end) {
      return num;
    }
    int oldStart = start;
    int oldEnd = end;
    int pivot = num[start];
    int index = start;
    boolean backward = true;
    while (start < end) {
      if (backward) {
        if (num[end] >= pivot) {
          end --;
        } else {
          num[index] = num[end];
          index = end;
          backward = false;
        }
      } else {
        if (num[start] <= pivot) {
          start ++;
        } else {
          num[index] = num[start];
          index = start;
          backward = true;
        }
      }
    }
    num[index] = pivot;
    quickSort(num, oldStart, start-1);
    quickSort(num, start+1, oldEnd);
    return num;
  }

  /**
   * 通过快速选择得到第k大的数
   */
  public static int findKthByQuickSelect(int[] num, int low, int high, int k) {
    System.out.println(low + ", " + high + ", " + k);
    int random = new Random().nextInt(high - low);
    int temp = num[low];
    num[low] = num[low + random];
    num[low +random] = temp;
    int start = low, end = high;
    int pivot = num[start];
    int index = start;
    boolean backward = true;
    while (start < end) {
      if  (backward) {
        if (num[end]>=pivot) {
          end --;
        } else {
          num[index] = num[end];
          backward = false;
          index = end;
        }
      } else {
        if (num[start] <= pivot) {
          start++;
        } else {
          num[index] = num[start];
          backward = true;
          index = start;
        }
      }
    }
    num[index] = pivot;
    if (index == k - 1) {
      return pivot;
    } else if (index > k-1) {
      return findKthByQuickSelect(num, low, index-1, k);
    } else {
      return findKthByQuickSelect(num,index+1, high, k);
    }
  }
  public static void main(String[] args) {
    int num[] = {1,5,6,2,1,44,-2,-2,189241,21,19};
    int[] num2 = quickSort(num, 0, num.length-1);
    for (int i = 0; i< num2.length; i++) {
      System.out.printf(num2[i] + ",");
    }
    System.out.println(findKthByQuickSelect(num, 0, num.length -1, 7));
  }
}
