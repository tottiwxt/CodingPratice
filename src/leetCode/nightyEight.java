package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 2020-05-05 16:57
 */
public class nightyEight {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
       TreeNode(int x) { val = x; }
    }


  class Solution {
    public boolean isValidBST(TreeNode root) {
      if(root == null || (root.left == null && root.right == null)){
        return true;
      }
      if(root.left != null){
        List<Integer> nodes = getLeft(root.left);
        for(Integer node : nodes){
          if(node>=root.val){
            return false;
          }
        }
      }
      if(root.right != null){
        List<Integer> nodes = getLeft(root.right);
        for(Integer node : nodes){
          if(node>=root.val){
            return false;
          }
        }
      }
      return isValidBST(root.left) && isValidBST(root.right);
    }

    public List<Integer> getLeft(TreeNode root){
      //获取root的所有子节点
      List<Integer> list = new ArrayList<>();
      TreeNode leftNode = root.left;
      TreeNode rightNode = root.right;
      if(leftNode != null){
        list.add(leftNode.val);
        list.addAll(getLeft(leftNode.left));
        list.addAll(getLeft(leftNode.right));
      }
      if(rightNode != null){
        list.add(rightNode.val);
        list.addAll(getLeft(rightNode.left));
        list.addAll(getLeft(rightNode.right));
      }
      return list;
    }
  }
}
