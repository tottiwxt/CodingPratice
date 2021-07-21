package ByteDance;

import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 6/29/21 12:28 AM
 */
public class Q8 {

  public static boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')' || ch == '}' || ch == ']') {
        if (!stack.empty()) {
          char last = stack.pop();
          switch (ch) {
            case ')':
              if (last != '(') {
                return false;
              }
              break;
            case '}':
              if (last != '{') {
                return false;
              }
              break;
            case ']':
              if (last != '[') {
                return false;
              }
              break;
            default:
              break;
          }
        } else {
          return false;
        }

      } else {
        return false;
      }
    }
    if (stack.empty()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(isValid("(){}[]"));
    System.out.println(isValid("({[]})"));
    System.out.println(isValid("({[])})"));

  }

  /**
   * 给定一个只包含三种字符的字符串：（?，）?和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
   *
   * 任何左括号 (?必须有相应的右括号 )。
   * 任何右括号 )?必须有相应的左括号 (?。
   * 左括号 ( 必须在对应的右括号之前 )。
   * *?可以被视为单个右括号 )?，或单个左括号 (?，或一个空字符串。
   * 一个空字符串也被视为有效字符串。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param s
   * @return
   */
  public boolean checkValidString(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int l_min = 0;
    int l_max = 0;
    for (int i = 0; i<s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        l_min ++;
        l_max ++;
      } else if (ch == '*') {
        l_min --;
        l_max ++;
      } else if (ch == ')') {
        l_min--;
        l_max--;
      }
      if (l_max<0) {
        return false;
      }
      l_min = l_min<0?0:l_min;
    }
    if (l_min<=0 && l_max >= 0) {
      return true;
    }
    return false;
  }

  public boolean checkValid(String s, int index, Stack old) {
    return false;
  }
}
