package leetCode;

/**
 * @Description:����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
 *
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ�������������磬121 �ǻ��ģ��� 123 ���ǡ�
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺x = 121 �����true
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/palindrome-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 3/2/21 7:49 PM
 */
public class isPalindrome {

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x == 0) {
      return true;
    }
    String str = String.valueOf(x);
    int s = 0;
    int e = str.length() - 1;
    while (s < e) {
      if (str.charAt(s) != str.charAt(e)) {
        return false;
      }
      s++;
      e--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(12321));
  }
}
