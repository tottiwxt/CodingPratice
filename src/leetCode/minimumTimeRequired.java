package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的
 * 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3 输出：3 解释：给每位工人分配一项工作，最大工作时间是 3 。 示例 2：
 *
 * 输入：jobs = [1,2,4,7,8], k = 2 输出：11 解释：按下述方式分配工作： 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11） 2
 * 号工人：4、7（工作时间 = 4 + 7 = 11） 最大工作时间是 11 。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 5/10/21 9:39 PM
 */
public class minimumTimeRequired {

  public static int minimumTimeRequired(int[] jobs, int k) {
    quickSort(jobs, 0, jobs.length - 1);
    int[] sum = new int[k + 1];
    for (int i = 0; i < k; i++) {
      sum[i] = 0;
    }
    int index = 0;
    boolean forward = true;
    int max = 0;

    for (int i = jobs.length - 1; i >= 0; i--) {
      sum[index] += jobs[i];
      if (sum[index] > max) {
        max = sum[index];
      }
      int min = max;
      int minIndex = index;
      for (int h = 0; h < k; h++) {
        if (sum[h] < min) {
          min = sum[h];
          minIndex = h;
        }
      }
      index = minIndex;
    }
    return max;
  }

  public static void quickSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
    }
    int i = start, j = end;
    int target = nums[i];
    int index = i;
    boolean backward = true;
    while (i < j) {
      if (backward) {
        if (nums[j] < target) {
          nums[index] = nums[j];
          index = j;
          backward = false;
        } else {
          j--;
        }
      } else {
        if (nums[i] > target) {
          nums[index] = nums[i];
          index = i;
          backward = true;
        } else {
          i++;
        }
      }
    }
    nums[i] = target;
    quickSort(nums, start, i - 1);
    quickSort(nums, i + 1, end);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 4, 7, 8};
//    quickSort(nums, 0, nums.length - 1);
//    for (int i = 0; i < nums.length; i++) {
//      System.out.println(nums[i]);
//    }
    System.out.println(minimumTimeRequired(nums, 2));
  }
}
