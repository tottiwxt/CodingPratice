package leetCode;

import leetCode.swapPairs.ListNode;

/**
 * @Description: ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 * @Author: wangxutao@qiyi.com
 * @Date: 4/17/21 4:06 PM
 */
public class mergeTwoLists {

  public class ListNode {

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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode fakeHead = new ListNode();
    ListNode res = fakeHead;
    //���ڱ���2���ڵ�Ƚϣ�ѡ���С����Ϊ��һ��ָ��
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        fakeHead.next = l1;
        l1 = l1.next;
      } else {
        fakeHead.next = l2;
        l2 = l2.next;
      }
      fakeHead = fakeHead.next;
    }
    if (l1!=null) {
      fakeHead.next = l1;
    }
    if (l2!=null) {
      fakeHead.next = l2;
    }
    return res.next;
  }
}
