package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 一条包含字母?A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6) "KJF" ，将消息分组为 (11 10 6) 注意，消息不能分组为? (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于
 * "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decode-ways
 * @Author: wangxutao@qiyi.com
 * @Date: 4/21/21 2:52 PM
 */
public class numDecodings {

  public static int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int tail = s.length() - 1;
    Map<Integer, Integer> memory = new HashMap<>();
    return getNumDecodings(s, tail, memory);
  }

  public static int getNumDecodings(String s, int tail, Map<Integer, Integer> memory) {
    if (tail < 0) {
      return 1;
    }
    // 只有1位了
    if (tail == 0) {
      char ch = s.charAt(tail);
      if (ch >= '1' && ch <= '9') {
        return 1;
      }
    } else {
      char ch1 = s.charAt(tail - 1);
      char ch2 = s.charAt(tail);
      if (ch1 == '0' || ch1 > '2') {
        if (ch2 == '0') {
          return 0;
        }
        if (memory.containsKey(tail - 1)) {
          return memory.get(tail-1);
        } else {
          int sum = getNumDecodings(s, tail - 1,memory);
          memory.put(tail-1, sum);
          return sum;
        }
      } else if (ch1 == '1') {
        if (ch2 == '0') {
          if (memory.containsKey(tail-2)) {
            return memory.get(tail-2);
          } else {
            int sum = getNumDecodings(s, tail - 2,memory);
            return sum;
          }
        }
        if (!memory.containsKey(tail-1)) {
          memory.put(tail-1, getNumDecodings(s, tail - 1, memory));
        }
        if (!memory.containsKey(tail-2)) {
          memory.put(tail-2, getNumDecodings(s, tail - 2, memory));
        }
        return  memory.get(tail-1)+ memory.get(tail-2);
      } else if (ch1 == '2') {
        if (ch2 > '6') {
          if (!memory.containsKey(tail-1)) {
            memory.put(tail-1, getNumDecodings(s, tail - 1,memory));
          }
          return memory.get(tail-1);
        } else {
          if (ch2 == '0') {
            if (!memory.containsKey(tail-2)) {
              memory.put(tail-2, getNumDecodings(s, tail - 2,memory));
            }
            return memory.get(tail-2);
          }
          if (!memory.containsKey(tail-1)) {
            memory.put(tail-1, getNumDecodings(s, tail - 1, memory));
          }
          if (!memory.containsKey(tail-2)) {
            memory.put(tail-2, getNumDecodings(s, tail - 2, memory));
          }
          return  memory.get(tail-1)+ memory.get(tail-2);
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("226"));
  }

}
