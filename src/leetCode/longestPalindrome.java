package leetCode;

/**
 * @Description: ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ���?s ����󳤶�Ϊ 1000��
 *
 * ʾ�� 1��
 *
 * ����: "babad" ���: "bab" ע��: "aba" Ҳ��һ����Ч�𰸡�
 *
 * ʾ�� 2��
 *
 * ����: "cbbd" ���: "bb"
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/longest-palindromic-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 1/7/21 9:27 PM
 */
public class longestPalindrome {

  public static String longestPalindrome2(String s) {
    if (s.length() <= 1) {
      return s;
    }
    int maxLength = 0;
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        if (s.charAt(i) == s.charAt(j - 1)) {
          String subStr = s.substring(i, j);
          if (subStr.length() > maxLength && isPalind(subStr)) {
            result = subStr;
            maxLength = subStr.length();
          }
        }

      }
    }
    return result;
  }

  private static boolean isPalind(String s) {
    String reverse = "";
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public static String longestPalindrome(String s) {
    if (s.length() <= 1) {
      return s;
    }
    String str = "#";
    String result = "";
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      str += s.charAt(i) + "#";
    }
    System.out.println(str);
    int[] len = new int[str.length()];
    for (int i = 0; i < str.length() - 1; i++) {
      len[i] = calPalindLength(str, i);
      if (len[i] > max) {
        max = len[i];
        result = str.substring(i - max, i+max+1).replaceAll("#","");
      }
    }
    return result;
  }

  private static int calPalindLength(String str, int position) {
    int maxLength = 0;
    for (int i = 1; ; i++) {
      if (position - i < 0) {
        break;
      }
      if (position + i >= str.length()) {
        break;
      }
      if (str.charAt(position - i) != str.charAt(position + i)) {
        break;
      }
      maxLength++;
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("abcbc"));
//    System.out.println(isPalind("abbca"));
  }
}
