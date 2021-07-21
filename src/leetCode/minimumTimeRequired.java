package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:����һ���������� jobs ������ jobs[i] ����ɵ� i ���Ҫ���ѵ�ʱ�䡣
 *
 * ���㽫��Щ��������� k λ���ˡ����й�����Ӧ�÷�������ˣ���ÿ���ֻ�ܷ����һλ���ˡ����˵� ����ʱ�� ����ɷ�������ǵ����й�������ʱ����ܺ͡��������һ����ѵĹ������䷽����ʹ���˵�
 * �����ʱ�� ���� ��С�� ��
 *
 * ���ط��䷽���о����� ��С �� �����ʱ�� ��
 *
 * ʾ�� 1��
 *
 * ���룺jobs = [3,2,3], k = 3 �����3 ���ͣ���ÿλ���˷���һ����������ʱ���� 3 �� ʾ�� 2��
 *
 * ���룺jobs = [1,2,4,7,8], k = 2 �����11 ���ͣ���������ʽ���乤���� 1 �Ź��ˣ�1��2��8������ʱ�� = 1 + 2 + 8 = 11�� 2
 * �Ź��ˣ�4��7������ʱ�� = 4 + 7 = 11�� �����ʱ���� 11 ��
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
