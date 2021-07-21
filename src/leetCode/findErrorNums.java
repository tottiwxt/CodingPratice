package leetCode;

/**
 * @Description:集合 s 包含从 1 到?n?的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * ?
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/4/21 7:53 PM
 */
public class findErrorNums {
  public int[] findErrorNums(int[] nums) {
    //递增数列求和 sum = (a1+an)/2 * n;
    int[] res = new int[2];
    int sum = 0;
    for (int i = 0; i<nums.length; i++) {
      int num = nums[i];
      if (num<0) {
        num *= -1;
      }
      sum += num;
      if (nums[num-1] > 0) {
        nums[num-1] *= -1;
      } else {
        res[0] = num;
      }
    }
    int oldSum = (int) ((1d + nums.length)/2 * nums.length);
    res[1] = (oldSum - sum) + res[0];
    return res;
  }
}
