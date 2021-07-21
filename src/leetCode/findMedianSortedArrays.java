package leetCode;

/**
 * @Description: ����������СΪ m �� n �����򣨴�С��������?nums1 ��?nums2�������ҳ������������������������λ����
 *
 * ���ף��������һ��ʱ�临�Ӷ�Ϊ O(log (m+n)) ���㷨�����������
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Author: wangxutao@qiyi.com
 * @Date: 1/4/21 4:37 PM
 */
public class findMedianSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length = nums1.length + nums2.length;
    boolean type = length % 2 == 0;
    int midIndex = type ? length / 2 - 1 : length / 2;
    int index1 = 0;
    int index2 = 0;
    for (int i = 0; i < midIndex; i++) {
      if (index1 >= nums1.length) {
        index2++;
      } else if (index2 >= nums2.length) {
        index1++;
      } else if (nums1[index1] < nums2[index2]) {
        index1++;
      } else {
        index2++;
      }
    }
    if (type) {
      //ż��
      if (index1 >= nums1.length) {
        return ((double)nums2[index2] + (double)nums2[index2+1]) / 2;
      } else if (index2 >= nums2.length) {
        return ((double)nums1[index1] + (double)nums1[index1+1]) / 2;
      } else if (nums1[index1] < nums2[index2]) {
        int a = nums1[index1];
        index1++;
        if (index1 >= nums1.length) {
          return ((double)nums2[index2] + (double)a) / 2;
        } else if (index2 >= nums2.length) {
          return ((double)nums1[index1] + (double)a) / 2;
        } else if (nums1[index1] <= nums2[index2]) {
          return ((double) nums1[index1] + (double) a) / 2;
        } else {
          return ((double) nums2[index2] + (double) a) / 2;
        }
      } else if (nums1[index1] == nums2[index2]) {
        return (double) nums1[index1];
      } else {
        int a = nums2[index2];
        index2++;
        if (index1 >= nums1.length) {
          return ((double)nums2[index2] + (double)a) / 2;
        } else if (index2 >= nums2.length) {
          return ((double)nums1[index1] + (double)a) / 2;
        } else if (nums1[index1] <= nums2[index2]) {
          return ((double) nums1[index1] + (double) a) / 2;
        } else {
          return ((double) nums2[index2] + (double) a) / 2;
        }
      }
    } else {
      if (index1 >= nums1.length) {
        return (double) nums2[index2];
      } else if (index2 >= nums2.length) {
        return (double) nums1[index1];
      } else if (nums1[index1] <= nums2[index2]) {
        return (double) nums1[index1];
      }
      return (double) nums2[index2];
    }
  }

  public static void main(String[] args) {
    int num1[] = {};
    int num2[] = {1,2,3,4,5};
    System.out.println(findMedianSortedArrays(num1, num2));
    System.out.println(4 / 2);
  }
}
