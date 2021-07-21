package leetCode;

/**
 * @Description: ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ���?Z �������С�
 *
 * ���������ַ���Ϊ "PAYPALISHIRING"?����Ϊ 3 ʱ���������£�
 *
 * P   A   H   N A P L S I I G Y   I   R ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"PAHNAPLSIIGYIR"��
 *
 * ����ʵ��������ַ�������ָ�������任�ĺ�����
 *
 * string convert(string s, int numRows); ?
 *
 * ʾ�� 1��
 *
 * ���룺s = "PAYPALISHIRING", numRows = 3 �����"PAHNAPLSIIGYIR" ʾ�� 2�� ���룺s = "PAYPALISHIRING", numRows =
 * 4 �����"PINALSIGYAHRPI" ���ͣ� P     I    N A   L S  I G Y A   H R P     I
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/zigzag-conversion
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
        //���ң���ʼ�����·��ƶ�
        paralle = false;
      } else if (y == 0) {
        //���������ƶ�
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
