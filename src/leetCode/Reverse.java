package leetCode;

/**
 * @Description: ����һ�� 32 λ���з������� x ������ x ��ÿλ�ϵ����ַ�ת��Ľ����
 *
 * �����ת���������� 32 λ���з��������ķ�Χ?[?231,? 231?? 1] ���ͷ��� 0��
 *
 * ���軷��������洢 64 λ�������з��Ż��޷��ţ���
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/reverse-integer
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 1/25/21 5:15 PM
 */
public class Reverse {

  public static int reverse(int x) {


    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
      rev = rev * 10 + pop;
    }
    return rev;
  }

  public static void main(String[] args) {
    System.out.println(reverse(-123));
  }
}
