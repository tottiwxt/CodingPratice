package leetCode;

import leetCode.minDiffInBST.TreeNode;

/**
 * @Description:����һ���������ĸ��ڵ� root ������ÿ���ڵ㶼�����һ�� 0 �� 9 ֮������֡�
 * ÿ���Ӹ��ڵ㵽Ҷ�ڵ��·��������һ�����֣�
 *
 * ���磬�Ӹ��ڵ㵽Ҷ�ڵ��·�� 1 -> 2 -> 3 ��ʾ���� 123 ��
 * ����Ӹ��ڵ㵽Ҷ�ڵ����ɵ� ��������֮�� ��
 *
 * Ҷ�ڵ� ��ָû���ӽڵ�Ľڵ㡣
 *
 *
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
