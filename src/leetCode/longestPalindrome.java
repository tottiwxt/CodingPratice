package leetCode;

/**
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设?s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd" 输出: "bb"
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
