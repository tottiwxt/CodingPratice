package ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: ������ ��α���
 * ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 *
 * ?
 *
 * ʾ����
 * ��������[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * �����������������
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
        //��
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
      //ѹ����ѹ��
      while (!temp.isEmpty()) {
        stack.push(temp.pop());
      }
    }
    return res;
  }
}
