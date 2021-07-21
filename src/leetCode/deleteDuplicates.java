package leetCode;

/**
 * @Description:����һ�����������е�����������������ͷ�ڵ� head ������ɾ�������ظ���Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ��
 *
 * ����ͬ�����������еĽ������
 * @Author: wangxutao@qiyi.com
 * @Date: 4/19/21 8:48 PM
 */
public class deleteDuplicates {

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


  /**
   * @Description:����һ�����������е�����������������ͷ�ڵ� head ������ɾ�������ظ���Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ��
   *
   * ����ͬ�����������еĽ������
   * @Author: wangxutao@qiyi.com
   * @Date: 4/19/21 8:48 PM
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode fakeHead = new ListNode();
    fakeHead.next = head;
    int value = head.val;
    while (head != null && head.next != null) {
      if (head.next.val == value) {
        head.next = head.next.next;
      } else {
        value = head.next.val;
        head = head.next;
      }
    }
    return fakeHead.next;
  }


  /**
   * @Description:����һ�����������е�����������������ͷ�ڵ� head ������ɾ�����������д��������ظ�����Ľڵ㣬ֻ����ԭʼ������?û���ظ�����?�����֡�
   *
   * ����ͬ�����������еĽ������
   *
   * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
   * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
   *
   * ����ͬ�����������еĽ������
   * @Author: wangxutao@qiyi.com
   * @Date: 4/19/21 8:48 PM
   */
  public static ListNode deleteDuplicates2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fakeHead = new ListNode();
    ListNode lastSuvivor = null;
    Integer val = Integer.MAX_VALUE;
    // ������һ����ȷ�Ľڵ�
    while (head != null && head.next != null) {
      //�¸��ڵ��ֵ�͵�һ����һ����������ǰ
      if (head.val != val && head.next.val != head.val) {
//        System.out.println("ѡ����һ���� : " + lastSuvivor.val);

        lastSuvivor = head;
        fakeHead.next = lastSuvivor;
        break;
      } else {
        val = head.val;
      }
      head = head.next;
      System.out.println("head = " + head.val + ", val = " + val);

    }
    if (lastSuvivor == null && head.val != val) {
      lastSuvivor = head;
      fakeHead.next = lastSuvivor;
      val = lastSuvivor.val;
    }

    // ÿ����������������һ���ĵ㣬�Ͱ�suvivor��nextָ���һ����
    while (head != null && head.next != null) {
      if (head.val != val && head.next.val != head.val) {
        System.out.println("ѡ���¸��� : " + head.val);
        lastSuvivor.next = head;
        lastSuvivor = lastSuvivor.next;
        head = head.next;
      } else {
        val = head.val;
      }
      head = head.next;
    }
    if (head.val != val) {
      lastSuvivor.next = head;
    } else {
      if (lastSuvivor != null) {
        lastSuvivor.next = null;
      }
    }
    return fakeHead.next;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(1);
//    ListNode node3 = new ListNode(2);

    node1.next = node2;
//    node2.next = node3;
    ListNode res = deleteDuplicates2(node1);
    while (res != null) {
      System.out.printf(res.val + ", ");
      res = res.next;
    }
  }
}
