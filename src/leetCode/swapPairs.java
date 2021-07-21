package leetCode;

/**
 * @Description:����һ���������������������ڵĽڵ㣬�����ؽ����������
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 * ʾ�� 1��
 *
 * ���룺head = [1,2,3,4]
 * �����[2,1,4,3]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
      //����
      //������
      ListNode temp = left.next;
      //��ָ�����¸��ڵ�
      left.next = left.next.next;
      //��ָ����
      temp.next = left;
      //��һ��ָ���ʱ����
      lastTail.next = temp;
      System.out.println("temp.val = " + temp.val);
      lastTail = left;
      left = left.next;
      System.out.println("left.val = " + left.val);
    }
    return fakeHead.next;
  }
}
