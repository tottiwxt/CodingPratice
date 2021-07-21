package leetCode;

/**
 * @Description:
 * һ��������λ��һ�� m x n?��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 *
 * ���ܹ��ж�������ͬ��·����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/unique-paths
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 12/24/20 4:01 PM
 */
public class UniquePath62 {

  public static void main(String[] args) {
    System.out.println(uniquePath(3,7));
  }

  public static int uniquePath(int m, int n) {
    if (m == 0 || n == 0) return 0;
    int[][] dp = new int[m][n];
    for (int i = 0; i<n ; i++) {
      dp[0][i] = 1;
    }
    for (int i = 0; i<m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <m; i++) {
      for (int j = 1; j<n; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }
    return dp[m-1][n-1];
  }
}
