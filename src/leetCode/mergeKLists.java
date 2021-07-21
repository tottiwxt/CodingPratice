package leetCode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description:给你一个链表数组，每个链表都已经按升序排列。 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]] 输出：[1,1,2,3,4,4,5,6] 解释：链表数组如下： [ 1->4->5, 1->3->4, 2->6 ]
 * 将它们合并到一个有序链表中得到。 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 4/21/21 8:47 PM
 */
public class mergeKLists {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  static class NodeInfo {
    //第几个链表
    int index;
    ListNode node;

    NodeInfo(int index, ListNode node) {
      this.index = index;
      this.node = node;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 1){
      return lists[0];
    }
    ListNode fakeHead = new ListNode(-1);
    ListNode head = new ListNode(-1);
    fakeHead = head;
    TreeSet<NodeInfo> treeSet = new TreeSet<NodeInfo>(new ListNodeCompator());
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        treeSet.add(new NodeInfo(i, lists[i]));
        lists[i] = lists[i].next;
      }
    }
    while (!treeSet.isEmpty()) {
      NodeInfo smallest = treeSet.pollFirst();
      int index = smallest.index;
      if (smallest.node != null) {
        // 添加节点
        head.next = smallest.node;
        head = head.next;
        // 补充tree
        //todo 笨比操作，不需要存index的，直接用弹出node的next就好
        if (lists[index] != null) {
          treeSet.add(new NodeInfo(index, lists[index]));
          lists[index] = lists[index].next;
        }
      }
    }
    return fakeHead.next;
  }

  public static class ListNodeCompator implements Comparator<NodeInfo> {
    @Override
    public int compare(NodeInfo o1, NodeInfo o2) {
      int num = o1.node.val - o2.node.val;
      return num == 0 ? 1 : num;
    }
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(20);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(55);
    ListNode n4 = new ListNode(44);
    ListNode[] list = {n1, n2, n3, n4};
    mergeKLists(list);
  }
}
