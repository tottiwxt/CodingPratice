package ByteDance;

import java.util.Stack;

/**
 * @Description: 大数相加
 * @Author: wangxutao@qiyi.com
 * @Date: 4/26/21 1:13 AM
 */
public class Q3 {

  public static String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1, add = 0;
    StringBuffer str = new StringBuffer();
    while (i >= 0 || j >= 0) {
      int x = i >= 0 ? num1.charAt(i) - '0' : 0;
      int y = j >= 0 ? num2.charAt(j) - '0' : 0;
      int sum = x + y + add;
      str.append(sum % 10);
      if (sum > 9) {
        add = 1;
      } else {
        add = 0;
      }
      i--;
      j--;
    }
    if (add > 0) {
      str.append(1);
    }
    return String.valueOf(str.reverse());
  }

  public static void main(String[] args) {
    System.out.println(addStrings("11", "22"));
    System.out.println(addStrings("99", "1"));

  }
}
