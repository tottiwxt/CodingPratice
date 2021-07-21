package leetCode;

/**
 * @Description: 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：* 输入：nums = [1,2,0] 输出：3
 *
 * 示例 2： 输入：nums = [3,4,-1,1] 输出：2
 *
 * 示例 3： 输入：nums = [7,8,9,11,12] 输出：1
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 5/18/21 3:10 PM
 */
public class firstMissingPositive {

  public static int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length ==0) {
      return -1;
    }
    int length = nums.length;
    for (int i = 0; i< nums.length; i++) {
      if (nums[i] <= 0) {
        nums[i] = length+1;
      }
    }

    for (int i = 0; i< length; i++) {
      int index = nums[i];
      if (index>0 && index<length+1) {
        if (nums[index-1] > 0) {
          nums[index-1] = nums[index-1] * -1;
        }
      } else if (index<0 && index > -1 * (length+1)){
        index = index * -1;
        if (nums[index-1] > 0) {
          nums[index-1] = nums[index-1] * -1;
        }
      }
    }

    for (int i = 0; i<length; i++) {
      if (nums[i] > 0) {
        return i+1;
      }
    }

    return length+1;
  }


  public static void main(String[] args) {
    int[] nums = {1,2,0};
    System.out.println(firstMissingPositive(nums));
  }
}
