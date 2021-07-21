package leetCode;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 4/20/21 4:23 PM
 */
public class strStr {

  public int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        if (isSame(haystack, needle, i)) {
          return i;
        }
      }
    }
    return -1;
  }

  public boolean isSame(String str, String target, int index) {
    for (int i = 0; i < target.length(); i++, index++) {
      if (index > str.length()-1){
        return false;
      }
      if (target.charAt(i) != str.charAt(index)) {
        return false;
      }
    }
    return true;
  }
}
