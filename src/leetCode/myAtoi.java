package leetCode;

import sun.swing.StringUIClientPropertyKey;

/**
 * @Description: 请你来实现一个?myAtoi(string s)?函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数?myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格 检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" ->
 * 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。 如果整数数超过 32 位有符号整数范围 [?231,? 231?? 1]
 * ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 ?231 的整数应该被固定为 ?231 ，大于 231?? 1 的整数应该被固定为 231?? 1 。 返回整数作为最终结果。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 1/25/21 5:33 PM
 */
public class myAtoi {

  public static int myAtoi(String s) {
    String resStr = "";
    boolean noSymbol = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        // 非法字符
        if (resStr.length() == 0) {
          continue;
        } else {
          break;
        }
      } else {
        if ((resStr.length() == 0 || (resStr.length() == 1 && (resStr.charAt(0) == '+' || resStr.charAt(1) =='-'))) && s.charAt(i) == '0' ){
          noSymbol = true;
          continue;
        }
        if (resStr.length() > 11) {
          if (resStr.charAt(0) == '-') {
            return Integer.MIN_VALUE;
          } else {
            return Integer.MAX_VALUE;
          }
        }
        if ((s.charAt(i) == '+' && resStr.length() == 0 && !noSymbol) || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
          resStr += s.charAt(i);
        } else if (s.charAt(i) == '-' && resStr.length() == 0 && !noSymbol) {
          resStr += "-";
        } else {
          break;
        }
      }
    }
    if (resStr.length() == 0 || (resStr.length() == 1 && (resStr.charAt(0) >= '9'
        || resStr.charAt(0) <= '0'))) {
      return 0;
    }
    int num ;
    try {
      num = Integer.parseInt(resStr);
    } catch (Exception e) {
      if (resStr.charAt(0) == '-') {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("00000-42a1234"));
  }
}
