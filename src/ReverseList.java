import java.io.IOException;
import java.util.Stack;


public class ReverseList {
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
//	public static ListNode ReverseList(ListNode head) {
//		Stack<Integer> stack = new Stack<Integer>();
//		while(head!=null){
//			stack.push(head.val);
//			System.out.println(head.val);
//			head = head.next;
//			
//		}
//		int num =stack.pop();
//	    ListNode result = new ListNode(num);
//    	System.out.println(result.val);
//	    //result = result.next;
//	    ListNode tmp2 = result;
//	    while(!stack.empty()){
//	    	num =stack.pop();
//	    	ListNode tmp = new ListNode(num);
//	    	//System.out.println(tmp);
//	    	while(result!=null){
//	    		tmp2 = result.next;
//	    	}
//	    	tmp2.next = tmp;
//	    }
//		
//		
//		return result;
//
//    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       // String str = null; 
        
        //str = br.readLine(); 
       // reverse(str);
       ListNode a = new ListNode(1);
       ListNode b = new ListNode(2);
       ListNode c = new ListNode(3);
       ListNode d = new ListNode(4);
       a.next = b;
       b.next = c;
       c.next = d;
       ReverseList(a);
    		
        
	}

	private static ListNode ReverseList(ListNode a) {
		// TODO Auto-generated method stub
		ListNode NewHead = null;
		ListNode tmp = null;
		ListNode pre = null;
		while(a!=null){
			tmp = a.next;
			a.next = pre;
			pre = a;
			a = tmp;
			if(a == null){
				NewHead = pre;
				//a = tmp.next;
			}
		}
		
		return NewHead;
	}
}
