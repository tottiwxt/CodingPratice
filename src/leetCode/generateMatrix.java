package leetCode;

/**
 * @Description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @Author: wangxutao@qiyi.com
 * @Date: 3/16/21 11:10 PM
 */
public class generateMatrix {

  public static int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int x = 0;
    int y = 0;
    //1 左往右； 2 上往下； 3右往左； 4下往上
    int direction = 1;
    for (int num = 1; num <= n * n; num++) {
      matrix[x][y] = num;
      if (direction == 1) {
        //左往右
        if (y + 1 < n && matrix[x][y + 1] == 0) {
          y++;
        } else {
          direction = 2;
          x++;
        }
      } else if (direction == 2) {
        //上往下
        if (x + 1 < n && matrix[x + 1][y] == 0) {
          x++;
        } else {
          direction = 3;
          y--;
        }
      } else if (direction == 3) {
        //右往左
        if (y - 1 >= 0 && matrix[x][y - 1] == 0) {
          y--;
        } else {
          direction = 4;
          x--;
        }
      } else if (direction == 4) {
        //下往上
        if (x - 1 >= 0 && matrix[x - 1][y] == 0) {
          x--;
        } else {
          direction = 1;
          y++;
        }
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix = generateMatrix(3);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.println(matrix[i][j]);
      }
    }
    System.out.println(generateMatrix(3));
  }
}
