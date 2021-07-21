package leetCode;

import sun.swing.StringUIClientPropertyKey;

/**
 * @Description: ������ʵ��һ��?myAtoi(string s)?������ʹ���ܽ��ַ���ת����һ�� 32 λ�з������������� C/C++ �е� atoi ��������
 *
 * ����?myAtoi(string s) ���㷨���£�
 *
 * �����ַ������������õ�ǰ���ո� ����һ���ַ������軹δ���ַ�ĩβ��Ϊ�����Ǹ��ţ���ȡ���ַ�������У��� ȷ�����ս���Ǹ������������� ������߶������ڣ���ٶ����Ϊ����
 * ������һ���ַ���ֱ��������һ���������ַ��򵽴�����Ľ�β���ַ��������ಿ�ֽ������ԡ� ��ǰ�沽��������Щ����ת��Ϊ����������"123" -> 123�� "0032" ->
 * 32�������û�ж������֣�������Ϊ 0 ����Ҫʱ���ķ��ţ��Ӳ��� 2 ��ʼ���� ������������� 32 λ�з���������Χ [?231,? 231?? 1]
 * ����Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ��̶�Ϊ ?231 ������ 231?? 1 ������Ӧ�ñ��̶�Ϊ 231?? 1 �� ����������Ϊ���ս����
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/string-to-integer-atoi
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 1/25/21 5:33 PM
 */
public class myAtoi {

  public static int myAtoi(String s) {
    String resStr = "";
    boolean noSymbol = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        // �Ƿ��ַ�
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
