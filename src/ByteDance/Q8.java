package ByteDance;

import java.util.Stack;

/**
 * @Description: ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ��� s ���ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ� �����ű�������ȷ��˳��պϡ�
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
   * ����һ��ֻ���������ַ����ַ�������?����?�� *��дһ����������������ַ����Ƿ�Ϊ��Ч�ַ�������Ч�ַ����������¹���
   *
   * �κ������� (?��������Ӧ�������� )��
   * �κ������� )?��������Ӧ�������� (?��
   * ������ ( �����ڶ�Ӧ��������֮ǰ )��
   * *?���Ա���Ϊ���������� )?���򵥸������� (?����һ�����ַ�����
   * һ�����ַ���Ҳ����Ϊ��Ч�ַ�����
   *
   * ��Դ�����ۣ�LeetCode��
   * ���ӣ�https://leetcode-cn.com/problems/valid-parenthesis-string
   * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
