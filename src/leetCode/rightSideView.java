package leetCode;

import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetCode.minDiffInBST.TreeNode;

/**
 * @Description: ¶þ²æÊ÷µÄÓÒÊÓÍ¼
 * @Author: wangxutao@qiyi.com
 * @Date: 5/20/21 8:09 PM
 */
public class rightSideView {
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
  public List<Integer> rightSideView(TreeNode root) {

    if (root == null) {return null;}
    List<Integer> res = new ArrayList<>();
    res.add(root.val);
    Stack<TreeNode> stack = new Stack<>();
    addNode(root, stack);
    while (!stack.isEmpty()) {
      List<TreeNode> temp = new ArrayList<>();
      while (!stack.isEmpty()) {
        temp.add(stack.pop());
      }
      for (int i = temp.size()-1; i>=0; i--) {
        if (i == 0) {
          res.add(temp.get(i).val);
        }
        addNode(temp.get(i), stack);
      }
    }
    return res;
  }

  private void addNode(TreeNode node, Stack<TreeNode> stack){
    if (node.left!=null) {
      stack.push(node.left);
    }
    if (node.right!=null) {
      stack.push(node.right);
    }
  }
}
