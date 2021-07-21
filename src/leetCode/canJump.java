package leetCode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * https://leetcode-cn.com/problems/jump-game/
 * @Author: wangxutao@qiyi.com
 * @Date: 4/21/21 11:07 PM
 */
public class canJump {

  public boolean canJump(int[] nums) {
    int farest = nums[0];
    for (int i = 0; i <= farest; i++) {
      if (i + nums[i] > farest) {
        farest = i + nums[i];
      }
      if (farest >= nums.length-1) {
        return true;
      }
    }
    return false;
  }

  /**
   * 在巨量数据时超时
   */
  /*public boolean canJump2(int[] nums) {
    if (nums.length <= 1) {
      return true;
    }
    int maxStep = nums[0];
    if (maxStep == 0) {
      return false;
    }
    boolean flag = false;
    Map<Integer, Boolean> memory = new HashMap<>();
    for (int i = 1; i <= maxStep && i < nums.length; i++) {
      flag = flag || calJump2(nums, i, memory);
      if (flag == true) {
        return flag;
      }

    }
    return flag;
  }

  public boolean calJump2(int[] nums, int index, Map<Integer, Boolean> memory) {
    if (index == nums.length - 1) {
      return true;
    }
    if (memory.containsKey(index)) {
      return memory.get(index);
    }
    int maxStep = nums[index];
    boolean flag = false;
    for (int i = 1; i <= maxStep && index + i < nums.length; i++) {
      if (!memory.containsKey(index + i)) {
        memory.put(index + i, calJump2(nums, index + i, memory));
      }
      flag = flag || memory.get(index + i);
      if (flag == true) {
        return true;
      }
    }
    return false;
  }*/

  /**
   * 在巨量数据时超时
   */
  /*public boolean canJump(int[] nums) {
    if (nums.length <= 1) {
      return true;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Boolean> memory = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      int maxStep = nums[i];
      for (int step = 1; step <= maxStep && i + step < nums.length; step++) {
        if (!map.containsKey(i + step)) {
          List<Integer> l = new ArrayList<>();
          l.add(i);
          map.put(i + step, l);
        } else {
          List<Integer> l = map.get(i + step);
          l.add(i);
          map.put(i + step, l);
        }
      }
    }
    return calJump(map, nums.length - 1, memory);
  }

  public boolean calJump(Map<Integer, List<Integer>> map, int index, Map<Integer, Boolean> memory) {
    List<Integer> l = map.get(index);
    if (l == null) {
      return false;
    }
    if (l.contains(0)) {
      return true;
    }
    boolean flag = false;
    for (int i = 0; i < l.size(); i++) {
      int key = l.get(i);
      if (!memory.containsKey(key)) {
        memory.put(key, calJump(map, key, memory));
      }
      flag = flag || memory.get(key);
      if (flag == true) {
        return true;
      }
    }
    return false;
  }*/
}
