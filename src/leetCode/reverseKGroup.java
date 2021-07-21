package leetCode;

/**
 * @Description:
 * 给你一个链表，每?k?个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k?是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是?k?的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 3/8/21 7:30 PM
 */
public class reverseKGroup {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 1) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode next = dummy;
    boolean gameover = false;
    while (head.next != null) {
      // 选取k节
      ListNode start = head;
      ListNode end = null;
      for (int i = 0; i < k - 1; i++) {
        if (head.next != null) {
          head = head.next;
          end = head;
        } else {
          gameover = true;
          break;
        }
      }
      if (gameover) {
        //彻底结束，return
        return dummy.next;
      }
      next = end.next;
      pre.next = end;
      pre = start;
      end.next = null;
      //翻转[start, end]
      reverseSubGroup(start).next = next;
      head = next;
      if (head == null) break;
    }
    return dummy.next;
  }

  public static ListNode reverseSubGroup(ListNode head) {
    ListNode pre = null;
    ListNode res = head;
    while (head != null) {
      ListNode temp = head.next;
      head.next = pre;
      pre = head;
      head = temp;
    }
    return res;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    ListNode node8 = new ListNode(8);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = null;

    ListNode pre = node1;
//    ListNode temp = node1.next;
    node1 = node2;
    System.out.println(node1.val);
    System.out.println(pre.val);

    ListNode next = node3;
//    ListNode temp = node1.next;
    node3 = node4;
    System.out.println(node3.val);
    System.out.println(next.val);

    ListNode node = (reverseKGroup(node1, 3));
    while (node.next != null) {
      System.out.println(node.val);
      node = node.next;
    }

  }

}
