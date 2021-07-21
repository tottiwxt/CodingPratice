package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description:给你一个整数数组 nums 和两个整数?k 和 t 。 请你判断是否存在 两个不同下标 i 和 j，使得?abs(nums[i] - nums[j]) <= t
 * ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 示例?1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0 输出：true
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
