package leetCode;

import leetCode.minDiffInBST.TreeNode;

/**
 * @Description:给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 4/13/21 2:46 PM
 */
public class sumNumbers {

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

  public static int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left != null && root.right != null) {
      return addNode(root.left, root.val) + addNode(root.right, root.val);
    } else if (root.left!=null && root.right == null) {
      return addNode(root.left, root.val);
    } else {
      return addNode(root.right, root.val);
    }
  }

  public static int addNode(TreeNode root, int parent) {
    if (root==null) {
      return parent;
    }
    parent = parent * 10 + root.val;
    if (root.left != null && root.right != null) {
      return addNode(root.left, parent) + addNode(root.right, parent);
    } else if (root.left!=null && root.right == null) {
      return addNode(root.left, parent);
    } else {
      return addNode(root.right, parent);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(6);
    root.left = left;
    root.right = right;
//    TreeNode left2 = new TreeNode(1);
//    TreeNode right2 = new TreeNode(3);
//    left.left = left2;
//    left.right = right2;
    System.out.println(sumNumbers(root));
  }
}
