package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Description:
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/3/21 2:00 PM
 */
public class frequencySort {

  public String frequencySort(String s) {
    if (null == s || s.length() == 0) {
      return "";
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int count = map.getOrDefault(ch, 0);
      map.put(ch, count + 1);
    }
    List<Character> list = new ArrayList<>(map.keySet());
    Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < list.size(); i++) {
      char ch = list.get(i);
      int times = map.get(ch);
      while (times > 0) {
        sb.append(ch);
        times--;
      }
    }
    return sb.toString();
  }
}
