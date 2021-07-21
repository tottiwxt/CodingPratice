package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: https://leetcode-cn.com/problems/word-break/
 * @Author: wangxutao@qiyi.com
 * @Date: 2020-06-25 17:49
 *
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict���ж�?s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
 *
 * ˵����
 *
 * ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ� ����Լ����ֵ���û���ظ��ĵ��ʡ� ʾ�� 1��
 *
 * ����: s = "leetcode", wordDict = ["leet", "code"] ���: true ����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet
 * code"�� ʾ�� 2��
 *
 * ����: s = "applepenapple", wordDict = ["apple", "pen"] ���: true ����: ���� true ��Ϊ "applepenapple"
 * ���Ա���ֳ� "apple pen apple"�� ?    ע��������ظ�ʹ���ֵ��еĵ��ʡ� ʾ�� 3��
 *
 * ����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] ���: false
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/word-break ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class WordBreak {

  public static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet(wordDict);
    int dp[] = new int[s.length()+1];
    dp[0] = 1;
    for (int i = 1; i < s.length(); i++) {
      dp[i] = 0;
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] == 1 && wordDictSet.contains(s.substring(j, i))) {
          dp[i] = 1;
          break;
        }
      }
    }
    return dp[s.length()] == 1;
  }

  public static void main(String[] args) {
    List<String> wordDict = new ArrayList<>();
    wordDict.add("apple");
    wordDict.add("pen");
    System.out.println(wordBreak("applepenapple", wordDict));
  }
}
