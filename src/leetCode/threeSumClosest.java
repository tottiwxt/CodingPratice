package leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: ����һ������?n ������������?nums?�� һ��Ŀ��ֵ?target���ҳ�?nums?�е�����������ʹ�����ǵĺ���?target?��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 *
 * ʾ����
 *
 * ���룺nums = [-1,2,1,-4], target = 1 �����2 ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/3sum-closest ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
