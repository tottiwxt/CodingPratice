package leetCode;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 3/13/21 2:54 PM
 */
public class maxArea {

  public final static int LEFT_SMALL = 0;
  public final static int RIGHT_SMALL = 1;
  public final static int EQUAL = 2;
  public static int flag = 0;
  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left <= right -1) {
      int area = (right - left) * min(height[left], height[right]);
      if (area > max) {
        max = area;
      }
      if (flag == LEFT_SMALL) {
        left ++;
      } else {
        right--;
      }
    }
    return max;
  }

  public static int min(int x, int y) {
    if (x < y) {
      flag = LEFT_SMALL;
      return x;
    } else if (x == y) {
      flag = EQUAL;
      return x;
    } else {
      flag = RIGHT_SMALL;
      return y;
    }
  }


  public static void main(String[] args) {
    int[] height = {2, 3, 4, 5, 18, 17, 6};
    System.out.println(maxArea(height));
  }
}
