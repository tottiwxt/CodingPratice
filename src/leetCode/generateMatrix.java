package leetCode;

/**
 * @Description: ����һ�������� n ������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е� n x n �����ξ��� matrix ��
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @Author: wangxutao@qiyi.com
 * @Date: 3/16/21 11:10 PM
 */
public class generateMatrix {

  public static int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int x = 0;
    int y = 0;
    //1 �����ң� 2 �����£� 3������ 4������
    int direction = 1;
    for (int num = 1; num <= n * n; num++) {
      matrix[x][y] = num;
      if (direction == 1) {
        //������
        if (y + 1 < n && matrix[x][y + 1] == 0) {
          y++;
        } else {
          direction = 2;
          x++;
        }
      } else if (direction == 2) {
        //������
        if (x + 1 < n && matrix[x + 1][y] == 0) {
          x++;
        } else {
          direction = 3;
          y--;
        }
      } else if (direction == 3) {
        //������
        if (y - 1 >= 0 && matrix[x][y - 1] == 0) {
          y--;
        } else {
          direction = 4;
          x--;
        }
      } else if (direction == 4) {
        //������
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
