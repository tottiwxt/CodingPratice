package leetCode;

/**
 * @Description:���� s ������ 1 ��?n?�����������ҵ��ǣ���Ϊ���ݴ��󣬵��¼�������ĳһ�����ָ����˳��˼������������һ�����ֵ�ֵ�����¼��� ��ʧ��һ������ ���� ��һ�������ظ� ��
 *
 * ����һ������ nums �����˼��� S ���������Ľ����
 *
 * �����ҳ��ظ����ֵ����������ҵ���ʧ�����������������������ʽ���ء�
 *
 * ?
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,2,4]
 * �����[2,3]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/set-mismatch
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 7/4/21 7:53 PM
 */
public class findErrorNums {
  public int[] findErrorNums(int[] nums) {
    //����������� sum = (a1+an)/2 * n;
    int[] res = new int[2];
    int sum = 0;
    for (int i = 0; i<nums.length; i++) {
      int num = nums[i];
      if (num<0) {
        num *= -1;
      }
      sum += num;
      if (nums[num-1] > 0) {
        nums[num-1] *= -1;
      } else {
        res[0] = num;
      }
    }
    int oldSum = (int) ((1d + nums.length)/2 * nums.length);
    res[1] = (oldSum - sum) + res[0];
    return res;
  }
}
