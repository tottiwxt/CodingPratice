package leetCode;

/**
 * @Description: ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 *
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 *
 * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]] �����7 ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С�� ʾ�� 2��
 *
 * ���룺grid = [[1,2,3],[4,5,6]] �����12
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/minimum-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 12/24/20 5:07 PM
 */
public class minPathSum64 {

  public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int dp[][] = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i-1][0] + grid[i][0];
    }
    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[0][i-1] + grid[0][i];
    }
    for (int i = 1; i < m; i ++)
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i-1][j] < dp[i][j-1] ? dp[i-1][j] + grid[i][j] : dp[i][j-1] + grid[i][j];
      }
    return dp[m-1][n-1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minPathSum(grid));
  }
}
