package leetCode;

/**
 * @Description:����һ������ nums?��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ����?val?��Ԫ�أ��������Ƴ���������³��ȡ�
 *
 * ��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
 *
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/remove-element
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 4/19/21 8:42 PM
 */
public class removeElement {

  public static int removeElement(int[] nums, int val) {
    int tail = nums.length - 1;
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      if (nums[i] == val) {
        if (i < tail) {
          nums[i] = nums[tail];
          tail --;
          i--;
          length --;
        } else if (i == tail){
          length --;
        }
      }
    }
    return length;
  }

  public static void main(String[] args) {
    System.out.println(1);
  }
}
