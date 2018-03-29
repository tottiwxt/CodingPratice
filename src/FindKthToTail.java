
public class FindKthToTail {

	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	
	 public ListNode FindKthToTail(ListNode head,int k) {
		 if(k==0 || head == null) return null;
		 ListNode a = head;
		 for(;k>=1;k--){  //k>=1  £¡£¡
			 head = head.next;
		 }
		 
		 while(head.next!=null){
			 
			 //a = a.next;
			 head = head.next;
		 }
		 
		 return a;
	    }
}
