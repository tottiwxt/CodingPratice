package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description:����һ���������� nums ����������?k �� t �� �����ж��Ƿ���� ������ͬ�±� i �� j��ʹ��?abs(nums[i] - nums[j]) <= t
 * ��ͬʱ������ abs(i - j) <= k ��
 *
 * ��������򷵻� true�������ڷ��� false��
 *
 * ʾ��?1��
 *
 * ���룺nums = [1,2,3,1], k = 3, t = 0 �����true
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/contains-duplicate-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 4/17/21 2:20 PM
 */
public class containsNearbyAlmostDuplicate {

  public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> treeSet = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (treeSet.size() > k) {
        treeSet.remove(Long.valueOf(nums[i-k-1]));
      }
      Long num = treeSet.ceiling(Long.valueOf(nums[i]) - t);
      if (num!=null && num <= (Long.valueOf(nums[i]) + t)) {
        return true;
      }
      treeSet.add(Long.valueOf(nums[i]));
    }
    return false;
  }

//  private static boolean insertSort(int num, ArrayList<Integer> list, int t) {
//    for (int i = 0; i < list.size(); i++) {
//      if (list.get(i)<=num + )
//    }
//    list.add(list.size(), num);
//    if (list.size() >= 2 && Math.abs(Long.valueOf(num) - Long.valueOf(list.get(list.size() - 2))) <= t) {
//      return true;
//    }
//    return false;
//  }


  public static void main(String[] args) {
    int[] num = {1, 5, 9, 1, 5, 9};
    System.out.println(containsNearbyAlmostDuplicate(num, 2, 3));
//    System.out.println(Math.abs(Long.valueOf(-2147483648L) - Long.valueOf(2147483647)));
  }
}
