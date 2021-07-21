package leetCode;

/**
 * @Description:存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
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
   * @Description:存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
   *
   * 返回同样按升序排列的结果链表。
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
   * @Description:存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中?没有重复出现?的数字。
   *
   * 返回同样按升序排列的结果链表。
   *
   * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * 返回同样按升序排列的结果链表。
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
    // 挑出第一个正确的节点
    while (head != null && head.next != null) {
      //下个节点的值和第一个点一样，继续往前
      if (head.val != val && head.next.val != head.val) {
//        System.out.println("选出第一个点 : " + lastSuvivor.val);

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

    // 每次遇到连续两个不一样的点，就把suvivor的next指向第一个点
    while (head != null && head.next != null) {
      if (head.val != val && head.next.val != head.val) {
        System.out.println("选出下个点 : " + head.val);
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
