package ByteDance;

import java.util.Scanner;

/**
 * @Description: 从指定十进制数组中去掉m个数字，希望留下的结果更大
 * 例如，指定354271,m=1,res=54271
 * m=2,res=5471
 * @Author: wangxutao@qiyi.com
 * @Date: 4/25/21 5:29 PM
 */
public class Q2 {
  public static String solution(String str, int cnt) {
    for (int i = 0; i<str.length()-1; i++) {
      if (str.charAt(i) < str.charAt(i+1)) {
        str = str.substring(0, i) + str.substring(i+1, str.length());
        cnt--;
        i = i>=1 ? i-2:i-1;
      }
      if (cnt == 0) {
        break;
      }
    }
    if (cnt > 0) {
      str = str.substring(0, str.length() - cnt);
    }
    return str;
  }


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()) {
      StringBuilder sb = new StringBuilder();
      sb.append(sc.next());
      int cnt = sc.nextInt();

      System.out.println(solution(String.valueOf(sb), cnt));
    }
  }
}
