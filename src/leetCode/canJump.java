package leetCode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 55. ��Ծ��Ϸ
 * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ���±ꡣ
 *
 * ʾ�� 1��
 *
 * ���룺nums = [2,3,1,1,4]
 * �����true
 * ���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ
 * ʾ�� 2��
 *
 * ���룺nums = [3,2,1,0,4]
 * �����false
 * ���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ
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
   * �ھ�������ʱ��ʱ
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
   * �ھ�������ʱ��ʱ
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
