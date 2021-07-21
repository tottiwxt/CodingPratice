package ByteDance;

/**
 * @Description: ip合法性判断 编写一个函数来验证输入的字符串是否是有效的 IPv4 或?IPv6 地址。
 *
 * 如果是有效的 IPv4 地址，返回 "IPv4" ； 如果是有效的 IPv6 地址，返回 "IPv6" ； 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4?地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为?0 -?255，?用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址?172.16.254.01 是不合法的。
 *
 * IPv6?地址由 8 组 16 进制的数字来表示，每组表示?16 比特。这些组数字通过 (":")分割。比如,??2001:0db8:85a3:0000:0000:8a2e:0370:7334
 * 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以，?2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6
 * address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。?比如，?2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如，?02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/validate-ip-address
 * @Author: wangxutao@qiyi.com
 * @Date: 4/27/21 1:00 AM
 */
public class Q4 {

  public static String validIPAddress(String IP) {
    if (IP == null || IP.length() == 0) {
      return "Neither";
    }
    if (IP.charAt(IP.length()-1) == '.' || IP.charAt(IP.length()-1) == ':'){
      return "Neither";
    }
    //ipv4
    if (IP.contains(".")) {
      String nums[] = IP.split("\\.");
      if (nums.length != 4) {
        return "Neither";
      }
      for (int i = 0; i < 4; i++) {
        if (nums[i].length() == 0 || nums[i].length()>3) {
          return "Neither";
        }
        if (nums[i].charAt(0) == '0' && nums[i].length() > 1) {
          return "Neither";
        }
        for (char ch : nums[i].toCharArray()) {
          if (ch < '0' || ch > '9') {
            return "Neither";
          }
        }
        Integer realNum = Integer.parseInt(nums[i]);
        if (realNum > 255) {
          return "Neither";
        }
      }
      return "IPv4";
    } else if (IP.contains(":")) {
      String nums[] = IP.split(":");
      if (nums.length != 8) {
        return "Neither";
      }
      for (int i = 0; i < 8; i++) {
        if (nums[i].length() == 0 || nums[i].length() > 4) {
          return "Neither";
        }
        char[] sub = nums[i].toCharArray();
        for (char ch : sub) {
          if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) {
            return "Neither";
          }
        }
      }
      return "IPv6";

    }
    return "Neither";
  }

  public static void main(String[] args) {
    System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
  }
}
