package leetCode;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 3/9/21 11:57 PM
 */
public class removeDuplicates {

  public static String removeDuplicates(String S) {
    StringBuffer stack = new StringBuffer();
    int index = -1;
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (index >=0 && ch == stack.charAt(index)) {
        stack.deleteCharAt(index);
        index--;
      } else {
        stack.append(ch);
        index ++;
      }
    }
    return stack.toString();
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("abbaca"));
  }
}
