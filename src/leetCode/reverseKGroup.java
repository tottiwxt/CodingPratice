package leetCode;

/**
 * @Description:
 * ����һ������ÿ?k?���ڵ�һ����з�ת�����㷵�ط�ת�������
 *
 * k?��һ��������������ֵС�ڻ��������ĳ��ȡ�
 *
 * ����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 *
 * ���ף�
 *
 * ��������һ��ֻʹ�ó�������ռ���㷨�������������
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
      // ѡȡk��
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
        //���׽�����return
        return dummy.next;
      }
      next = end.next;
      pre.next = end;
      pre = start;
      end.next = null;
      //��ת[start, end]
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
