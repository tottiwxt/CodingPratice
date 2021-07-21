package ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树 层次遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * ?
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/20/21 7:11 PM
 */
public class Q26 {
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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    Stack<TreeNode> temp = new Stack<>();
    if (root!=null) {
      stack.push(root);
    }
    while (!stack.isEmpty()) {
      List<Integer> layer = new ArrayList<>();
      while (!stack.isEmpty()) {
        //弹
        TreeNode node = stack.pop();
        if (node.left != null) {
          temp.push(node.left);
        }
        if (node.right != null) {
          temp.push(node.right);
        }
        layer.add(node.val);
      }
      res.add(layer);
      //压右再压左
      while (!temp.isEmpty()) {
        stack.push(temp.pop());
      }
    }
    return res;
  }
}
