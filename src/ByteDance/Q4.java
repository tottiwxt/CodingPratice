package ByteDance;

/**
 * @Description: ip�Ϸ����ж� ��дһ����������֤������ַ����Ƿ�����Ч�� IPv4 ��?IPv6 ��ַ��
 *
 * �������Ч�� IPv4 ��ַ������ "IPv4" �� �������Ч�� IPv6 ��ַ������ "IPv6" �� ��������������͵� IP ��ַ������ "Neither" ��
 * IPv4?��ַ��ʮ�������͵�����ʾ��ÿ����ַ���� 4 ��ʮ���������䷶ΧΪ?0 -?255��?��(".")�ָ���磬172.16.254.1��
 *
 * ͬʱ��IPv4 ��ַ�ڵ��������� 0 ��ͷ�����磬��ַ?172.16.254.01 �ǲ��Ϸ��ġ�
 *
 * IPv6?��ַ�� 8 �� 16 ���Ƶ���������ʾ��ÿ���ʾ?16 ���ء���Щ������ͨ�� (":")�ָ����,??2001:0db8:85a3:0000:0000:8a2e:0370:7334
 * ��һ����Ч�ĵ�ַ�����ң����ǿ��Լ���һЩ�� 0 ��ͷ�����֣���ĸ����ʹ�ô�д��Ҳ������Сд�����ԣ�?2001:db8:85a3:0:0:8A2E:0370:7334 Ҳ��һ����Ч�� IPv6
 * address��ַ (�������� 0 ��ͷ�����Դ�Сд)��
 *
 * Ȼ�������ǲ�����Ϊĳ�����ֵΪ 0����ʹ��һ���յ��飬�����ڳ��� (::) �������?���磬?2001:0db8:85a3::8A2E:0370:7334 ����Ч�� IPv6 ��ַ��
 *
 * ͬʱ���� IPv6 ��ַ�У������ 0 Ҳ�ǲ�������ġ����磬?02001:0db8:85a3:0000:0000:8a2e:0370:7334 ����Ч��
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/validate-ip-address
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
