package leetCode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: wangxutao@qiyi.com
 * @Date: 2020-05-16 13:45
 */
public class LengthOfLongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int max = 0;
    Map<Character, Integer> charMap = new HashMap<>();
    int left = 0;
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      if (charMap.get(ch) == null) {
        charMap.put(ch, i);
      } else {
        if ( charMap.get(ch) + 1 > left) {
          left = charMap.get(ch) + 1 ;

        }
        charMap.put(ch, i);

      }
      if (i - left + 1> max) {
        max = i - left + 1;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abba"));
  }
}
