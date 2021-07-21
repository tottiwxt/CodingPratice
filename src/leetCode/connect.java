package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 4/15/21 9:56 PM
 */
public class connect {

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    Queue<Node> queue = new LinkedList<>();
    ((LinkedList<Node>) queue).push(root);
    List<Node> temp = new ArrayList<>();
    while (!queue.isEmpty()) {
      while (!queue.isEmpty()) {
        ;
        temp.add(((LinkedList<Node>) queue).pollLast());
      }
      for (int i = 0; i < temp.size(); i++) {
        Node now = temp.get(i);
        if (i == temp.size() - 1) {
          now.next = null;
        } else {
          now.next = temp.get(i + 1);
        }
        if (now.left != null) {
          ((LinkedList<Node>) queue).push(now.left);
          ((LinkedList<Node>) queue).push(now.right);
        }
      }
      temp.clear();
    }
    return root;
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    ((LinkedList<Integer>) queue).push(1);
    ((LinkedList<Integer>) queue).push(2);
    ((LinkedList<Integer>) queue).push(3);
    System.out.println(((LinkedList<Integer>) queue).pollLast());
    System.out.println(queue.isEmpty());
    System.out.println(((LinkedList<Integer>) queue).pollLast());
    System.out.println(((LinkedList<Integer>) queue).pollLast());
    System.out.println(queue.isEmpty());
  }
}
