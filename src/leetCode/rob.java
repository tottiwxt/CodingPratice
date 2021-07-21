package leetCode;

/**
 * @Description: ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 *
 * ? ʾ�� 1��
 *
 * ���룺[1,2,3,1] �����4 ���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)�� ?    ͵�Ե�����߽�� = 1 + 3 = 4 ��
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/house-robber ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 4/15/21 1:09 AM
 */
public class rob {

  public static int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = nums[0] >= nums[1] ? nums[0] : nums[1];
    for (int i = 2; i < nums.length; i++) {
      int stoleIt = nums[i] + dp[i - 2];
      int notStoleIt = dp[i - 1];
      dp[i] = stoleIt >= notStoleIt ? stoleIt : notStoleIt;
    }
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (dp[i] > sum) {
        sum = dp[i];
      }
    }
    return sum;
  }


}
