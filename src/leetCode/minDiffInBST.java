package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * @Author: wangxutao@qiyi.com
 * @Date: 4/13/21 1:11 AM
 */
public class minDiffInBST {

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

  public static int minDiffInBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    //中序遍历
    int min = midPath(root, new Diff(null, Integer.MAX_VALUE));

    return min;
  }

  public static Integer midPath(TreeNode root, Diff diff) {
    if (root == null) {
      return diff.min;
    }
    if (root.left != null) {
      diff.min = midPath(root.left, diff);
    }
    if (diff.lastNum!=null && root.val - diff.lastNum < diff.min) {
      diff.min = root.val - diff.lastNum;
    }
    diff.lastNum = root.val;
    if (root.right != null) {
      diff.min = midPath(root.right, diff);
    }
    return diff.min;
  }

  public static class Diff {
    Integer lastNum;
    Integer min;

    Diff(Integer lastNum, Integer min){
      this.lastNum = lastNum;
      this.min = min;
    }
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(6);
    root.left = left;
    root.right = right;
    TreeNode left2 = new TreeNode(1);
    TreeNode right2 = new TreeNode(3);
    left.left = left2;
    left.right = right2;
    System.out.println(minDiffInBST(root));
  }
}
