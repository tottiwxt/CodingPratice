
public class FindFirstCommonNode {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	 public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 ListNode p1 = pHead1;
		 ListNode p2 = pHead2;
		 int len = getLength(p1)-getLength(p2);
		 
		 if(len>=0){
			 while(len--!=0){
				 pHead1 = pHead1.next;
			 }
		 }
		 else if (len<=0){
			 while(len++!=0){
				 pHead2 = pHead2.next;
			 }
		 }
		 while(pHead1!=null){
			 if(pHead1==pHead2)	return pHead1;
			 else{
				 pHead1 = pHead1.next;
				 pHead2 = pHead2.next;
			 }
		 }
		 
		 return null;
	    }
	private int getLength(ListNode pHead) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(pHead!=null){
			pHead = pHead.next;
			sum++;
		}
		return sum;
	}
	 
}
