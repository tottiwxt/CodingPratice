package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: һ��������ĸ?A-Z ����Ϣͨ������ӳ������� ���� ��
 *
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Ҫ ���� �ѱ������Ϣ���������ֱ����������ӳ��ķ���������ӳ�����ĸ�������ж��ַ����������磬"11106" ����ӳ��Ϊ��
 *
 * "AAJF" ������Ϣ����Ϊ (1 1 10 6) "KJF" ������Ϣ����Ϊ (11 10 6) ע�⣬��Ϣ���ܷ���Ϊ? (1 11 06) ����Ϊ "06" ����ӳ��Ϊ "F" ����������
 * "6" �� "06" ��ӳ���в����ȼۡ�
 *
 * ����һ��ֻ�����ֵ� �ǿ� �ַ��� s ������㲢���� ���� ������ ���� ��
 *
 * ��Ŀ���ݱ�֤�𰸿϶���һ�� 32 λ ��������
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/decode-ways
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
    // ֻ��1λ��
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
