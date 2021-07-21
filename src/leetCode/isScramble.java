package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 4/16/21 2:32 PM
 */
public class isScramble {
  public static boolean isScramble(String s1, String s2) {
    List<String> allRes = getIsScramble(s1);
    System.out.println(allRes);
    if (allRes.contains(s2)) {
      return true;
    }
    return false;
  }

  public static List<String> getIsScramble(String s1) {
    Set<String> res = new HashSet<>();
    if (s1.length() <= 1) {
      res.add(s1);
      return new ArrayList<>(res);
    }
    for (int i = 1; i<s1.length(); i++) {
      //遍历切分
      String pre = s1.substring(0, i);
      String tail = s1.substring(i, s1.length());

      //交换
      List<String> preSet = getIsScramble(pre);
      //不交换
      List<String> tailSet = getIsScramble(tail);
      for (int j = 0; j<preSet.size(); j ++) {
        for (int h = 0; h < tailSet.size(); h++){
          res.add(preSet.get(j) + tailSet.get(h));
          res.add(tailSet.get(h) + preSet.get(j));
        }
      }
    }
    return new ArrayList<>(res);
  }

  public static void main(String[] args) {
    System.out.println(isScramble("great", "rgeat"));
  }
}
