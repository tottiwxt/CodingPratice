package leetCode;

/**
 * @Description:给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 4/17/21 3:41 PM
 */
public class swapPairs {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fakeHead = new ListNode();
    fakeHead.next = head.next;
    ListNode left = head;
    ListNode lastTail = new ListNode();
    while (left!=null && left.next!=null){
      //交换
      //保存右
      ListNode temp = left.next;
      //左指向下下个节点
      left.next = left.next.next;
      //右指向左
      temp.next = left;
      //上一段指向此时的右
      lastTail.next = temp;
      System.out.println("temp.val = " + temp.val);
      lastTail = left;
      left = left.next;
      System.out.println("left.val = " + left.val);
    }
    return fakeHead.next;
  }
}
