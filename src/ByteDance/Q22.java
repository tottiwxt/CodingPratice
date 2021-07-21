package ByteDance;

import com.sun.tools.corba.se.idl.InterfaceGen;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树中序遍历的非递归实现
 * @Author: wangxutao@qiyi.com
 * @Date: 7/18/21 6:47 PM
 */
public class Q22 {
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
  public List<Integer> preTree(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root != null) {
      stack.push(root);
      while (stack!=null) {
        TreeNode node = stack.pop();
        list.add(node.val);

        if (node.right != null) {
          stack.push(node.right);
        }
        if (node.left!= null) {
          stack.push(node.left);
        }
      }
    }
    return list;
  }

  public List<Integer> midTree(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
   while (root != null || !stack.isEmpty()) {
       if (root!= null) {
         stack.push(root);
         root = root.left;
       } else {
         root = stack.pop();
         list.add(root.val);
         root = root.right;
       }
   }

    return list;
  }
}
