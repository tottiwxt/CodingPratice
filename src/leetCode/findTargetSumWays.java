package leetCode;

/**
 * @Description: ����һ���������� nums ��һ������ target ��
 *
 * �������е�ÿ������ǰ���?'+' �� '-' ��Ȼ�������������������Թ���һ�� ���ʽ ��
 *
 * ���磬nums = [2, 1] �������� 2 ֮ǰ��� '+' ���� 1 ֮ǰ��� '-' ��Ȼ���������õ����ʽ "+2-1" �� ���ؿ���ͨ��������������ġ����������� target
 * �Ĳ�ͬ ���ʽ ����Ŀ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,1,1,1,1], target = 3 �����5 ���ͣ�һ���� 5 �ַ���������Ŀ���Ϊ 3 ��
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/target-sum ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 6/7/21 8:30 PM
 */
public class findTargetSumWays {

  public int findTargetSumWays(int[] nums, int target) {

    return calSumWays(nums, nums.length - 1, target) ;
  }

  public int calSumWays(int[] nums, int length, int target) {
    if (length == 0) {
      if (target == nums[0] && target == -nums[0]) {
        return 2;
      } else if (target == nums[0] || target == -nums[0]) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return calSumWays(nums, length - 1, target + nums[length]) + calSumWays(nums, length - 1,
          target - nums[length]);
    }
  }
}
