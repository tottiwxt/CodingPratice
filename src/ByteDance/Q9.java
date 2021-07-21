package ByteDance;

/**
 * @Description: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3] 输出：[1,3,2]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/3/21 3:57 PM
 */
public class Q9 {

  public void nextPermutation(int[] nums) {
    if (nums.length == 0) {
      return;
    }

    int index = -1;
    int pos = 1;
    while (index < 0 && pos < nums.length){
      int tail_index = nums.length - pos;//2
      for (int i = tail_index -1 ; i >= 0; i--) {
        //遇到第一个比它后面小的a
        if (nums[i] < nums[i+1]) {
          int min = nums[i+1] - nums[i];
          int min_index = i+1;

          //就找出a屁股后面比他大的最小的数b，交换两人
          for (int j = i+2; j<nums.length; j++) {
            if (nums[j] > nums[i] && nums[j] - nums[i] <= min) {
              min = nums[j] - nums[i];
              min_index = j;
            }
          }
          int temp = nums[i];
          nums[i] = nums[min_index];
          nums[min_index] = temp;
          index = i;
          break;
        }
      }
      pos++;
    }


    //index后面的整个数组逆序
    reverseNum(nums, index + 1, nums.length - 1);
  }

  public void reverseNum(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}
