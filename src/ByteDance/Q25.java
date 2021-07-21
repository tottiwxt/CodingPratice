package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和?target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/20/21 2:27 PM
 */
public class Q25 {
  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    if (root != null) {
      calPathSum(root, target, res, path);
    }
    return res;
  }

  public void calPathSum(TreeNode root, int target, List<List<Integer>> res, List<Integer> path) {
    if (root == null) {
      if ( target == 0) {
        res.add(new ArrayList<>(path));
      }
      return;
    }

    path.add(root.val);
    if (root.left == null && root.right == null) {
      calPathSum(root.left, target - root.val, res, path);
    } else {
      if (root.left!=null){
        calPathSum(root.left, target - root.val, res, path);
      }
      if (root.right!=null) {
        calPathSum(root.right, target - root.val, res, path);
      }
    }

    if (path.size() > 0) {
      path.remove(path.size() - 1);
    }
  }
}
