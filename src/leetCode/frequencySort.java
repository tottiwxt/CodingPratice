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
 * ����һ���ַ������뽫�ַ�������ַ����ճ��ֵ�Ƶ�ʽ������С�
 *
 * ʾ�� 1:
 *
 * ����:
 * "tree"
 *
 * ���:
 * "eert"
 *
 * ����:
 * 'e'�������Σ�'r'��'t'��ֻ����һ�Ρ�
 * ���'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-characters-by-frequency
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
