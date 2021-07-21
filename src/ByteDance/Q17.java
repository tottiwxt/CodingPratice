package ByteDance;

import java.util.LinkedList;

/**
 * @Description:���� A ����̵ķǿ�����������ĳ��ȣ���������ĺ�����Ϊ K ��
 *
 * ���û�к�����Ϊ?K?�ķǿ������飬����?-1?��
 *
 *
 * ʾ�� 1��
 *
 * ���룺A = [1], K = 1
 * �����1
 * ʾ�� 2��
 *
 * ���룺A = [1,2], K = 4
 * �����-1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
