package leetCode;

/**
 * @Description: 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 输入：nums = [3,30,34,5,9] 输出："9534330" https://leetcode-cn.com/problems/largest-number/
 * @Author: wangxutao@qiyi.com
 * @Date: 4/12/21 10:43 AM
 */
public class largestNumber {

  public static String largestNumber(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    String str = "";
    for (int i = 0; i < nums.length; i++) {
      if (!(str.equals("0") && nums[i]==0)){
        str += nums[i];
      }
    }
    return str;
  }


  public static void quickSort(int[] nums, int begin, int end) {
    if (begin >= end) {
      return;
    }
    int i = begin;
    int j = end;
    boolean forward = false;
    int num = nums[begin];
    Integer temp_index = null;
    while (i != j && i < j) {
      if (forward) {
        //从前向后，找小的
        while (isLarger(nums[i], num) && j > i) {
//        while (nums[i] > num && j > i) {
          i++;
        }
        //找到
        if (j != i) {
          nums[temp_index] = nums[i];
          temp_index = i;
        }
        forward = false;
      } else {
        //从后向前，找大的
        while (isLarger(num, nums[j]) && j > i) {
//        while (num > nums[j] && j > i) {
          j--;
        }
        //找到
        if (j != i) {
          if (temp_index == null) {
            nums[i] = nums[j];
            temp_index = j;
          } else {
            nums[temp_index] = nums[j];
            temp_index = j;
          }

        }
        forward = true;
        //没找到
      }
    }
    nums[i] = num;
    quickSort(nums, begin, i - 1);
    quickSort(nums, i + 1, end);
  }

  /**
   * 比较两个数的字典序大小
   */
  public static boolean isLarger(int x, int y) {
    String num1 = String.valueOf(x);
    String num2 = String.valueOf(y);
    Long v1 = Long.parseLong(num1  + num2);
    Long v2 = Long.parseLong(num2  + num1);

//    for (int i = 0; i < num1.length(); i++) {
//      if (num2.length() - 1 < i) {
//        if (num1.charAt(i) > num2.charAt(i - 1)) {
//          return true;
//        }
//        return false;
//      }
//      char ch1 = num1.charAt(i);
//      char ch2 = num2.charAt(i);
//      if (ch1 > ch2) {
//        return true;
//      } else if (ch1 < ch2) {
//        return false;
//      }
//    }
    return v1>=v2;
  }

  public static void main(String[] args) {
    int[] nums = {0, 0};
//    quickSort(nums, 0, 4);
//    for (int i = 0; i < nums.length; i++) {
//      System.out.println(nums[i]);
//    }
    System.out.println(largestNumber(nums));
//    System.out.println(isLarger(30, 3));
//    System.out.println(isLarger(3, 5));
//    System.out.println(isLarger(11, 12));

  }
}
