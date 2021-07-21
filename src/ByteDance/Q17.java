package ByteDance;

import java.util.LinkedList;

/**
 * @Description:返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为?K?的非空子数组，返回?-1?。
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/10/21 10:29 PM
 */
public class Q17 {
  public int shortestSubarray(int[] nums, int k) {
    long P[] = new long[nums.length+1];
    P[0] = 0;
    for (int i = 1; i<= nums.length; i++) {
      P[i] = P[i-1] + nums[i-1];
    }
    int ans = nums.length + 1;
    LinkedList<Integer> queue = new LinkedList<>();
    for (int y = 0; y < nums.length; y++) {
      while (!queue.isEmpty() && P[queue.getLast()] >= P[y]) {
        queue.removeLast();
      }
      while (!queue.isEmpty() && P[queue.getFirst()] + k <= P[y]) {
        ans = y - queue.getFirst() <= ans? y-queue.getFirst() : ans;
        queue.removeFirst();
      }
      queue.add(y);
    }
    return ans < nums.length+1 ? ans : -1;
  }
}
