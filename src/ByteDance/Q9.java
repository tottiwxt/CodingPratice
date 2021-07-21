package ByteDance;

/**
 * @Description: ʵ�ֻ�ȡ ��һ������ �ĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
 *
 * �����������һ����������У��������������г���С�����У����������У���
 *
 * ���� ԭ�� �޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3] �����[1,3,2]
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/next-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 7/3/21 3:57 PM
 */
public class Q9 {

  public void nextPermutation(int[] nums) {
    if (nums.length == 0) {
      return;
    }

    int index = -1;
    int pos = 1;
    while (index < 0 && pos < nums.length){
      int tail_index = nums.length - pos;//2
      for (int i = tail_index -1 ; i >= 0; i--) {
        //������һ����������С��a
        if (nums[i] < nums[i+1]) {
          int min = nums[i+1] - nums[i];
          int min_index = i+1;

          //���ҳ�aƨ�ɺ�����������С����b����������
          for (int j = i+2; j<nums.length; j++) {
            if (nums[j] > nums[i] && nums[j] - nums[i] <= min) {
              min = nums[j] - nums[i];
              min_index = j;
            }
          }
          int temp = nums[i];
          nums[i] = nums[min_index];
          nums[min_index] = temp;
          index = i;
          break;
        }
      }
      pos++;
    }


    //index�����������������
    reverseNum(nums, index + 1, nums.length - 1);
  }

  public void reverseNum(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}
