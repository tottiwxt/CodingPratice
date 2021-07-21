package ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 给定升序整形数组，a、b是数组中的两个元素，求a+b=m的数据对有多少？
 * @Author: wangxutao@qiyi.com
 * @Date: 4/25/21 5:01 PM
 */
public class Q1 {

  public static List<List<Integer>> solution(int[] num, int target) {
    int i = 0;
    int j = num.length - 1;
    Map<Integer, List<Integer>> map = new HashMap<>();
    while (i < j) {
      if (num[i] + num[j] == target) {
        if (!map.containsKey(num[i] <= num[j] ? num[i] : num[j])) {
          List<Integer> list = new ArrayList<>();
          list.add(num[i]);
          list.add(num[j]);
          map.put(num[i] <= num[j] ? num[i] : num[j], list);
        }
        i++;
      } else if (num[i] + num[j] > target) {
        j--;
      } else if (num[i] + num[j] < target) {
        i++;
      }
    }
    return map.values().stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    int[] num1 = {1, 3, 4, 5, 6, 7, 9, 22};
    int[] num2 = {2, 3, 4, 4, 11, 33};
    System.out.println(solution(num1, 9));
  }
}
