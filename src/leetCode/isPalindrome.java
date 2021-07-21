package leetCode;

/**
 * @Description:给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：x = 121 输出：true
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
