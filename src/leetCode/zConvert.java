package leetCode;

/**
 * @Description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行?Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"?行数为 3 时，排列如下：
 *
 * P   A   H   N A P L S I I G Y   I   R 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows); ?
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3 输出："PAHNAPLSIIGYIR" 示例 2： 输入：s = "PAYPALISHIRING", numRows =
 * 4 输出："PINALSIGYAHRPI" 解释： P     I    N A   L S  I G Y A   H R P     I
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 1/16/21 5:14 PM
 */
public class zConvert {

  public static String convert2(String s, int numRows) {

    if (numRows == 1) {
      return s;
    }
    int row = (s.length() / (2 * numRows - 2) + 1) * (numRows - 1);
    if (row < numRows - 1) {
      row = numRows - 1;
    }
    char[][] matrix = new char[row][numRows];
    int x = 0;
    int y = 0;
    boolean paralle = true;
    for (int i = 0; i < s.length(); i++) {
      matrix[x][y] = s.charAt(i);
      if (y == numRows - 1) {
        //最右，开始往左下方移动
        paralle = false;
      } else if (y == 0) {
        //最左，向右移动
        paralle = true;
      }
      if (paralle) {
        y++;
      } else {
        x++;
        y--;
      }
    }
    String resut = "";

    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] != '\0') {
          resut += matrix[j][i];
        }
      }
    }

    return resut;
  }

  public static void main(String[] args) {
    System.out.println(convert(
        "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."
        , 10));
  }

  public static String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int all_step = numRows * 2 - 2;
    int first_step = all_step;
    int second_step = all_step - first_step;
    String result = "";
    for (int i = 0; i< numRows; i++) {
      int index = i;
      boolean isFirst = true;
      while (index < s.length()){
        result += s.charAt(index);
        if (isFirst) {
          if (first_step != 0) {
            index = index +first_step;
          } else {
            index = index +second_step;
          }
          isFirst = false;
        } else {
          if (second_step != 0) {
            index = index + second_step;
          } else {
            index = index + first_step;
          }
          isFirst = true;
        }
      }
      first_step = first_step - 2;
      second_step = second_step + 2;

    }
    return result;
  }
}
