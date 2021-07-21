package leetCode;


/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 1/1/21 11:57 PM
 */
public class lastStoneWeight {

  public static int lastStoneWeight(int[] stones) {
    int res = 0;
    if (stones.length == 1) {
      return stones[0];
    }
    stones = quickSort(stones, 0, stones.length - 1);
    for (int i = 1; i < stones.length; i++) {
      if (stones[1] == 0) {
        return stones[0];
      }
      stones[0] = stones[0] - stones[1];
      stones[1] = 0;
      stones = quickSort(stones, 0, stones.length - 1);

    }
    return stones[0];
  }

  public static int[] quickSort(int[] a, int start, int end) {
    if (start == end) {
      return a;
    }

    int i = start;
    int j = end;
    int temp = a[start];
    while (i < j) {
      while (i < j && a[j] <= temp) {
        j--;
      }
      a[i] = a[j];
      while (i < j && a[i] >= temp) {
        i++;
      }
      a[j] = a[i];
    }
    a[i] = temp;

    if (i - 1 > start) {
      a = quickSort(a, start, i - 1);
    }

    if (i + 1 < end) {
      a = quickSort(a, i + 1, end);
    }
    return a;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int num[] = {1,3};
    System.out.println( lastStoneWeight(num));
    for (int i = 0; i < num.length; i++) {
      System.out.println(num[i]);
    }
  }

}
