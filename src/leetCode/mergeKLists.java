package leetCode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description:����һ���������飬ÿ�������Ѿ����������С� ���㽫��������ϲ���һ�����������У����غϲ��������
 *
 * ʾ�� 1��
 *
 * ���룺lists = [[1,4,5],[1,3,4],[2,6]] �����[1,1,2,3,4,4,5,6] ���ͣ������������£� [ 1->4->5, 1->3->4, 2->6 ]
 * �����Ǻϲ���һ�����������еõ��� 1->1->2->3->4->4->5->6
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
    //�ڼ�������
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
        // ��ӽڵ�
        head.next = smallest.node;
        head = head.next;
        // ����tree
        //todo ���Ȳ���������Ҫ��index�ģ�ֱ���õ���node��next�ͺ�
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
