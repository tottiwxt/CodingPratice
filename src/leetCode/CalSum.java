package leetCode;

/**
 * @Description: https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: wangxutao@qiyi.com
 * @Date: 2020-05-16 13:10
 */
public class CalSum {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode res = new ListNode(0);
      ListNode head = res;
      int borrow = 0;
      while(l1!=null || l2!=null || borrow!=0){
        int num1 = l1!=null?l1.val : 0;
        int num2 = l2!=null?l2.val : 0;
        int sum_temp = num1 + num2 + borrow;
        borrow = 0;
        if(sum_temp >= 10){
          borrow = 1;
        }
        ListNode newNode = new ListNode(sum_temp % 10);
        res.next = newNode;
        res = res.next;
        l1 = l1!=null? l1.next:null;
        l2 = l2!=null? l2.next:null;
      }
      return head.next;
    }
  }
}
