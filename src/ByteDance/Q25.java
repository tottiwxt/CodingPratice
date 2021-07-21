package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * ����һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ��γ�һ��·����
 *
 * ʾ��:
 * �������¶��������Լ�Ŀ���?target = 22��
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * ����:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
