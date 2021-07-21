package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 4/20/21 4:52 PM
 */
public class letterCombinations {

  public final static char[][] button = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
      {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'}};

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if (digits == null || digits.length() == 0) {
      return result;
    }
    result.add("");
    for (char ch : digits.toCharArray()) {
      result = addChar(result, Integer.parseInt(String.valueOf(ch)));
    }
    return result;
  }

  public List<String> addChar(List<String> list, int b) {
    List<String> res = new ArrayList<>();
    for (String str : list) {
      for (char ch : button[b-1]) {
        res.add(str + ch);
      }
    }
    return res;
  }
}
