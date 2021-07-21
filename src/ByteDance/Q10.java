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
   * 给定一个数组 prices ，其中?prices[i] 是一支给定股票第 i 天的价格。
   *
   * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
   *
   * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
   *
   * ?
   *
   * 示例 1:
   *
   * 输入: prices = [7,1,5,3,6,4]
   * 输出: 7
   * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
   * ?    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

  public int maxProfit2(int[] prices) {
    int dp[][] = new int[prices.length][2];
    /**
     * dp[i][j]代表在第i天结束时，持有j个股票的最大收益
     */
    dp[0][0] = 0;
    dp[0][1] = 0 - prices[0];
    for (int i = 1; i < prices.length; i++) {
      //今天结束持有0个股票：昨天就没股票，或者把昨天的股票卖掉
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
      //今天结束持有1个股票：昨天就没股票今天买，或者把昨天的股票继续持有
      dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
    }

    return dp[prices.length-1][0]>dp[prices.length-1][1]?dp[prices.length-1][0]:dp[prices.length-1][1];
  }

  /**
   * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
   *
   * 设计一个算法来计算你所能获取的最大利润。你最多可以完成?两笔?交易。
   *
   * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
   *
   * ?
   *
   * 示例?1:
   *
   * 输入：prices = [3,3,5,0,0,3,1,4]
   * 输出：6
   * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
   * ?    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int dp[][] = new int[prices.length][4];

    /**
     * 每一天结束有5个状态：
     * 1.没有买卖过(忽略）
     * 2.买过1次
     * 3.买卖过1次
     * 4.之前买过2次，卖过1次
     * 5.完成了2次买卖
     */
    //买过1次
    dp[0][0] = 0-prices[0];
    //买卖过1次
    dp[0][1] = 0;
    //买2，卖1
    dp[0][2] = -prices[0];
    //买卖过2次
    dp[0][3] = 0;
    for (int i = 1; i < prices.length; i++) {
      //买过1次：前一天就买卖过今天不动 vs 前一天没买卖过今天买
      dp[i][0] = Math.max(dp[i-1][0], 0-prices[i]);
      //买卖过1次: 前一天就买卖过一次了 vs 前一天只买过1次今天卖掉
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
      //买2，卖1: 前一天就买卖过一次了今天再买 vs 前一天买2卖1了
      dp[i][2] = Math.max(dp[i-1][1] - prices[i], dp[i-1][2]);
      //买2，卖2: 前一天就买2卖1了今天再卖 vs 前一天买2卖2了
      dp[i][3] = Math.max(dp[i-1][2] + prices[i], dp[i-1][3]);
    }

    return dp[prices.length-1][1]>dp[prices.length-1][3]?dp[prices.length-1][1]:dp[prices.length-1][3];
  }



}
