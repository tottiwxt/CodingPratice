package ByteDance;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 7/3/21 5:07 PM
 */
public class Q10 {

  public int maxProfit1(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int highest = prices[prices.length - 1];
    int maxProfit = 0;
    for (int i = prices.length - 2; i >= 0; i--) {
      int earn = highest - prices[i];
      if (earn > maxProfit) {
        maxProfit = earn;
      }
      if (prices[i] > highest) {
        highest = prices[i];
      }
    }
    return maxProfit;
  }

  /**
   * ����һ������ prices ������?prices[i] ��һ֧������Ʊ�� i ��ļ۸�
   *
   * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
   *
   * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
   *
   * ?
   *
   * ʾ�� 1:
   *
   * ����: prices = [7,1,5,3,6,4]
   * ���: 7
   * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
   * ?    ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
   *
   * ��Դ�����ۣ�LeetCode��
   * ���ӣ�https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
   * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
   */

  public int maxProfit2(int[] prices) {
    int dp[][] = new int[prices.length][2];
    /**
     * dp[i][j]�����ڵ�i�����ʱ������j����Ʊ���������
     */
    dp[0][0] = 0;
    dp[0][1] = 0 - prices[0];
    for (int i = 1; i < prices.length; i++) {
      //�����������0����Ʊ�������û��Ʊ�����߰�����Ĺ�Ʊ����
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
      //�����������1����Ʊ�������û��Ʊ�����򣬻��߰�����Ĺ�Ʊ��������
      dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
    }

    return dp[prices.length-1][0]>dp[prices.length-1][1]?dp[prices.length-1][0]:dp[prices.length-1][1];
  }

  /**
   * ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
   *
   * ���һ���㷨�����������ܻ�ȡ��������������������?����?���ס�
   *
   * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
   *
   * ?
   *
   * ʾ��?1:
   *
   * ���룺prices = [3,3,5,0,0,3,1,4]
   * �����6
   * ���ͣ��ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
   * ?    ����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ��
   *
   * ��Դ�����ۣ�LeetCode��
   * ���ӣ�https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
   * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
   */
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int dp[][] = new int[prices.length][4];

    /**
     * ÿһ�������5��״̬��
     * 1.û��������(���ԣ�
     * 2.���1��
     * 3.������1��
     * 4.֮ǰ���2�Σ�����1��
     * 5.�����2������
     */
    //���1��
    dp[0][0] = 0-prices[0];
    //������1��
    dp[0][1] = 0;
    //��2����1
    dp[0][2] = -prices[0];
    //������2��
    dp[0][3] = 0;
    for (int i = 1; i < prices.length; i++) {
      //���1�Σ�ǰһ������������첻�� vs ǰһ��û������������
      dp[i][0] = Math.max(dp[i-1][0], 0-prices[i]);
      //������1��: ǰһ���������һ���� vs ǰһ��ֻ���1�ν�������
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
      //��2����1: ǰһ���������һ���˽������� vs ǰһ����2��1��
      dp[i][2] = Math.max(dp[i-1][1] - prices[i], dp[i-1][2]);
      //��2����2: ǰһ�����2��1�˽������� vs ǰһ����2��2��
      dp[i][3] = Math.max(dp[i-1][2] + prices[i], dp[i-1][3]);
    }

    return dp[prices.length-1][1]>dp[prices.length-1][3]?dp[prices.length-1][1]:dp[prices.length-1][3];
  }



}
