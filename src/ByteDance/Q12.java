package ByteDance;

/**
 * @Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * ?
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 输出：2 解释： 3x3 网格的正中间有一个障碍物。 从左上角到右下角一共有 2 条不同的路径： 1.
 * 向右 -> 向右 -> 向下 -> 向下 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/5/21 7:44 PM
 */
public class Q12 {

  /**
   * 超时
   */
  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

    int x = 0, y = 0;
    int sum = 0;
    int x_length = obstacleGrid.length;
    int y_length = obstacleGrid[0].length;
    if (x_length == 0 || y_length == 0) {
      return 0;
    }
    // 向右
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
    // 向下
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
