package leetCode;

/**
 * @Description: ����һ��δ������������� nums �������ҳ�����û�г��ֵ���С����������
 *
 * ����ʵ��ʱ�临�Ӷ�Ϊ O(n) ����ֻʹ�ó����������ռ�Ľ��������
 *
 * ʾ�� 1��* ���룺nums = [1,2,0] �����3
 *
 * ʾ�� 2�� ���룺nums = [3,4,-1,1] �����2
 *
 * ʾ�� 3�� ���룺nums = [7,8,9,11,12] �����1
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/first-missing-positive
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 5/18/21 3:10 PM
 */
public class firstMissingPositive {

  public static int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length ==0) {
      return -1;
    }
    int length = nums.length;
    for (int i = 0; i< nums.length; i++) {
      if (nums[i] <= 0) {
        nums[i] = length+1;
      }
    }

    for (int i = 0; i< length; i++) {
      int index = nums[i];
      if (index>0 && index<length+1) {
        if (nums[index-1] > 0) {
          nums[index-1] = nums[index-1] * -1;
        }
      } else if (index<0 && index > -1 * (length+1)){
        index = index * -1;
        if (nums[index-1] > 0) {
          nums[index-1] = nums[index-1] * -1;
        }
      }
    }

    for (int i = 0; i<length; i++) {
      if (nums[i] > 0) {
        return i+1;
      }
    }

    return length+1;
  }


  public static void main(String[] args) {
    int[] nums = {1,2,0};
    System.out.println(firstMissingPositive(nums));
  }
}
