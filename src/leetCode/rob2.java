package leetCode;

/**
 * @Description: ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�����
 * ��
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ ���ܹ�͵�Ե�����߽�
 *
 * ?
 *
 * ʾ��?1��
 *
 * ���룺nums = [2,3,2] �����3 ���ͣ��㲻����͵�� 1 �ŷ��ݣ���� = 2����Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/house-robber-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 4/15/21 1:20 AM
 */
public class rob2 {

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    //Ĭ��͵��һ��
    int[] dp1 = new int[nums.length];
    //Ĭ�ϲ�͵��һ��
    int[] dp2 = new int[nums.length];

    dp1[0] = nums[0];
    dp1[1] = nums[0];

    dp2[0] = 0;
    dp2[1] = nums[1];
    for (int i = 2; i < nums.length; i++) {
      dp1[i] = dp1[i - 2] + nums[i] > dp1[i - 1] ? dp1[i - 2] + nums[i] : dp1[i - 1];
      dp2[i] = dp2[i - 2] + nums[i] > dp2[i - 1] ? dp2[i - 2] + nums[i] : dp2[i - 1];

      if (i == nums.length - 1) {
        dp1[i] = dp1[i - 2] > dp1[i - 1] ? dp1[i - 2] : dp1[i - 1];
      }
    }
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (dp1[i] > sum) {
        sum = dp1[i];
      }
      if (dp2[i] > sum) {
        sum = dp2[i];
      }
    }
    return sum;
  }
}
