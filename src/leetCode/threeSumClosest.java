package leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: 给定一个包括?n 个整数的数组?nums?和 一个目标值?target。找出?nums?中的三个整数，使得它们的和与?target?最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1 输出：2 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 4/17/21 4:36 PM
 */
public class threeSumClosest {

  public static int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      return 0;
    }
//    quickSort(nums, 0, nums.length - 1);
    Arrays.sort(nums);
    int min_diff = Integer.MAX_VALUE;
    Integer diff = null;
    int result = 0;
    for (int a = 0; a <= nums.length - 3; a++) {
      int b = a + 1;
      int c = nums.length - 1;
      int last_diff = Integer.MAX_VALUE;
      while (b < c) {
        int sum = nums[a] + nums[b] + nums[c];
        diff = Math.abs(sum - target);
        if (diff == 0) {
          return target;
        }
        if (diff < min_diff) {
          min_diff = diff;
          result = sum;
        }
        if (sum < target) {
          b++;
        } else {
          c--;
        }
//        if (diff > last_diff) {
//          break;
//        } else {
//          last_diff = diff;
//        }
      }

    }
    return result;
  }

  public static void quickSort(int[] nums, int i, int j) {
    if (nums.length <= 1 || i >= j) {
      return;
    }
    int flag = nums[i];
    int left = i;
    int right = j;
    boolean direction = true;
    while (left < right) {
      if (direction) {
        if (nums[right] >= flag) {
          right--;
        } else {
          nums[left] = nums[right];
          direction = false;
        }
      } else {
        if (nums[left] <= flag) {
          left++;
        } else {
          nums[right] = nums[left];
          direction = true;
        }
      }
    }
    if (left == right) {
      nums[left] = flag;
    }
    quickSort(nums, i, left - 1);
    quickSort(nums, left + 1, j);
  }

  public static void main(String[] args) {
    int[] nums = {0,2,1,-3};
//    quickSort(nums, 0, 4);
//    for (int i = 0; i < nums.length; i++) {
//      System.out.println(nums[i]);
//    }
    System.out.println(threeSumClosest(nums, 1));
  }
}
