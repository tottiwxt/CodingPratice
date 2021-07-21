package leetCode;

/**
 * @Description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 * 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * ?
 *
 * 示例?1：
 *
 * 输入：nums = [2,3,2] 输出：3 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
    //默认偷第一家
    int[] dp1 = new int[nums.length];
    //默认不偷第一家
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
