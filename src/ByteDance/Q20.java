package ByteDance;

import java.util.Stack;

/**
 * @Description: 224. ���������� ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
 *
 * ʾ�� 1��
 *
 * ���룺s = "1 + 1" �����2 ʾ�� 2��
 *
 * ���룺s = " 2-1 + 2 " �����3 ʾ�� 3��
 *
 * ���룺s = "(1+(4+5+2)-3)+(6+8)" �����23
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
