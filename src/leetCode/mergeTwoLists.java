package leetCode;

import leetCode.swapPairs.ListNode;

/**
 * @Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
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
    //用于保持2个节点比较，选择较小的作为下一个指向
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
