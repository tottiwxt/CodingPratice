package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @Description: 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')'?（可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下?任意一条?要求：
 *
 * 空字符串或只包含小写字母的字符串 可以被写作?AB（A?连接?B）的字符串，其中?A?和?B?都是有效「括号字符串」 可以被写作?(A)?的字符串，其中?A?是一个有效的「括号字符串」 ?
 *
 * 示例 1：
 *
 * 输入：s = "lee(t(c)o)de)" 输出："lee(t(c)o)de" 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/3/21 2:29 PM
 */
public class minRemoveToMakeValid {

  public String minRemoveToMakeValid(String s) {
    Stack<Integer> leftPos = new Stack<>();
    int leftCount = 0;
    Set<Integer> toRemove = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        leftPos.push(i);
        leftCount++;
      } else if (ch == ')') {
        leftCount--;
        if (leftCount < 0) {
          leftCount++;
          toRemove.add(i);
        }
      }
    }
    while (leftCount > 0) {
      toRemove.add(leftPos.pop());
      leftCount--;
    }
    if (toRemove.size() > 0) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < s.length(); i++) {
        if (!toRemove.contains(i)) {
          sb.append(s.charAt(i));
        }
      }
      return sb.toString();
    } else {
      return s;
    }
  }
}
