package ByteDance;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 7/20/21 10:22 AM
 */
public class Q23 {

  public static String removeDuplicates(String S) {
    StringBuilder res = new StringBuilder();
    res.append(S.charAt(0));
    int length = 1;
    for(int i = 1; i< S.length();i++) {
      char ch = S.charAt(i);
      if (length > 0 && ch == res.charAt(length - 1)) {
        res.deleteCharAt(length - 1);
        length--;
      } else {
        res.append(ch);
        length++;
      }
    }
    return res.toString();
  }
}
