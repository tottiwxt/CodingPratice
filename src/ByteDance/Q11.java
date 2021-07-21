package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/4/21 11:40 AM
 */
public class Q11 {
  public List<List<Integer>> permute1(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length == 0 ) {
      return res;
    }
    List<Integer> numList = new ArrayList<Integer>();
    for (int i = 0; i< nums.length;i++) {
      numList.add(nums[i]);
    }
    backTrace(numList,0,res);
    return res;
  }

  public void backTrace(List<Integer> nums, int index, List<List<Integer>> res) {
    if (index == nums.size() - 1) {
      res.add(new ArrayList<Integer>(nums));
    } else {
     for (int i = index; i<nums.size(); i++) {
       Collections.swap(nums, i, index);
       backTrace(nums, index+1, res);
       Collections.swap(nums, i, index);
     }
    }
  }

  /**
   * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
   *
   *
   * 示例 1：
   *
   * 输入：nums = [1,1,2]
   * 输出：
   * [[1,1,2],
   *  [1,2,1],
   *  [2,1,1]]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/permutations-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param nums
   * @return
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length == 0 ) {
      return res;
    }
    List<Integer> numList = new ArrayList<Integer>();
    int[] used = new int[nums.length];
    for (int i = 0; i< nums.length;i++) {
      numList.add(nums[i]);
      used[i] = 0;
    }
    backTrace2(numList,0,res, used);
    return res;
  }

  public void backTrace2(List<Integer> nums, int index, List<List<Integer>> res, int[] used) {
    if (index == nums.size() - 1) {
      res.add(new ArrayList<Integer>(nums));
    } else {
      for (int i = index; i<nums.size(); i++) {
        if (!nums.get(i).equals(nums.get(index)) || used[index] == 1) {
          used[i] = 1;
          Collections.swap(nums, i, index);
          backTrace2(nums, index+1, res, used);
          Collections.swap(nums, i, index);
          used[i] = 0;
        }
      }
    }
  }
}
