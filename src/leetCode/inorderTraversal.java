package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: ����һ���������ĸ��ڵ� root ���������� ���� ������
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Author: wangxutao@qiyi.com
 * @Date: 3/13/21 5:09 PM
 */
public class inorderTraversal {
 public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  //�ݹ�
  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    addNode(list, root);
    return list;
  }

  private static void addNode(List<Integer> list, TreeNode node) {
   if (node != null) {
     addNode(list, node.left);
     list.add(node.val);
     addNode(list, node.right);
   } else {
     return;
   }
  }
  //����
  public static List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      list.add(root.val);
      root = root.right;
    }

    return list;
  }

  //����ǰ��
  public static List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root != null || !stack.isEmpty()) {
      stack.push(root);
      while (!stack.isEmpty()) {
        root = stack.pop();
        list.add(root.val);
        if (root.left!=null) {
          stack.push(root.left);
        }
        if (root.right != null) {
          stack.push(root.right);
        }
      }
    }

    return list;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    root.right = node1;
    node1.left = node3;
    System.out.println(inorderTraversal(root));
    System.out.println(inorderTraversal2(root));
    System.out.println(preorderTraversal2(root));

  }
}
