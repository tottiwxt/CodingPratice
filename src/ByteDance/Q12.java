package ByteDance;

/**
 * @Description: һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 *
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 *
 *
 *
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 * ���룺obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] �����2 ���ͣ� 3x3 ��������м���һ���ϰ�� �����Ͻǵ����½�һ���� 2 ����ͬ��·���� 1.
 * ���� -> ���� -> ���� -> ���� 2. ���� -> ���� -> ���� -> ����
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/unique-paths-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 7/5/21 7:44 PM
 */
public class Q12 {

  /**
   * ��ʱ
   */
  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

    int x = 0, y = 0;
    int sum = 0;
    int x_length = obstacleGrid.length;
    int y_length = obstacleGrid[0].length;
    if (x_length == 0 || y_length == 0) {
      return 0;
    }
    // ����
    sum = nextPos(obstacleGrid, 0, 0, x_length, y_length, sum);

    return sum;
  }

  public int nextPos(int[][] gird, int x, int y, int x_length, int y_length, int sum) {
    if (gird[x][y] == 1) {
      return sum;
    }
    if (x == x_length - 1 && y == y_length - 1) {
      return sum + 1;
    }
    if (x >= x_length || y >= y_length) {
      return 0;
    }
    if (y + 1 < y_length && gird[x][y + 1] != 1) {
      sum = nextPos(gird, x, y + 1, x_length, y_length, sum);
    }
    // ����
    if (x + 1 < x_length && gird[x + 1][y] != 1) {
      sum = nextPos(gird, x + 1, y, x_length, y_length, sum);
    }
    return sum;
  }


  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int x_length = obstacleGrid.length;
    int y_length = obstacleGrid[0].length;
    if (x_length == 0 || y_length == 0) {
      return 0;
    }
    int dp[][] = new int[x_length][y_length];
    boolean block = false;
    for (int i = 0; i < y_length; i++) {
      if (obstacleGrid[0][i] == 1) {
        block = true;
      }
      if (block) {
        dp[0][i] = 0;
      } else {
        dp[0][i] = 1;
      }
    }
    block = false;
    for (int i = 0; i < x_length; i++) {
      if (obstacleGrid[i][0] == 1) {
        block = true;
      }
      if (block) {
        dp[i][0] = 0;
      } else {
        dp[i][0] = 1;
      }
    }

    for (int x = 1; x < x_length; x++) {
      for (int y = 1; y < y_length; y++) {
        if (obstacleGrid[x][y] == 1) {
          dp[x][y] = 0;
        } else {
          dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
        }
      }
    }
    return dp[x_length - 1][y_length - 1];
  }
}
