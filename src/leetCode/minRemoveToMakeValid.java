package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @Description: ����һ���� '('��')' ��Сд��ĸ��ɵ��ַ��� s��
 *
 * ����Ҫ���ַ�����ɾ��������Ŀ�� '(' ���� ')'?������ɾ������λ�õ�����)��ʹ��ʣ�µġ������ַ�������Ч��
 *
 * �뷵������һ���Ϸ��ַ�����
 *
 * ��Ч�������ַ�����Ӧ����������?����һ��?Ҫ��
 *
 * ���ַ�����ֻ����Сд��ĸ���ַ��� ���Ա�д��?AB��A?����?B�����ַ���������?A?��?B?������Ч�������ַ����� ���Ա�д��?(A)?���ַ���������?A?��һ����Ч�ġ������ַ����� ?
 *
 * ʾ�� 1��
 *
 * ���룺s = "lee(t(c)o)de)" �����"lee(t(c)o)de" ���ͣ�"lee(t(co)de)" , "lee(t(c)ode)" Ҳ��һ�����д𰸡�
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
