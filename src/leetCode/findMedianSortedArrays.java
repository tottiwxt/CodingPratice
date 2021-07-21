package leetCode;

/**
 * @Description: 给定两个大小为 m 和 n 的正序（从小到大）数组?nums1 和?nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
      //偶数
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
