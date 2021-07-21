package ByteDance;

import java.util.Stack;

/**
 * @Description: 224. 基本计算器 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1" 输出：2 示例 2：
 *
 * 输入：s = " 2-1 + 2 " 输出：3 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)" 输出：23
 * @Author: wangxutao@qiyi.com
 * @Date: 7/18/21 4:35 PM
 */
public class Q20 {

  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int sum = 0;
    int num = 0;
    int op =1;
    Stack<Integer> sign = new Stack<>();
    sign.push(op);
    for (int i = 0; i< s.length(); i++) {
      char ch = s.charAt(i);
      if (ch <= '9' && ch >= '0') {
        num = num * 10  + (ch -'0');
        continue;
      }

      sum += op * num;
      num = 0;

      if (ch == '+') {
        op = sign.peek();
      } else if (ch == '-') {
        op = -1 * sign.peek();
      } else if (ch == '(') {
        sign.push(op);
      } else if (ch == ')') {
        sign.pop();
      }
    }
    sum += op * num;
    return sum;
  }

}
