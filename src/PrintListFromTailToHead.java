import java.util.ArrayList;
import java.util.Stack;


public class PrintListFromTailToHead {
	class ListNode{
		int val;
	    ListNode next;
	    ListNode(int val){
	        this.val=val;
	        this.next=null;
	    }
	}
	//·¨1
	/*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		 Stack<Integer> st = new Stack<Integer>();
		 ArrayList<Integer> list = new ArrayList<Integer> ();
		while(listNode!=null){
			st.push(listNode.val);
			listNode = listNode.next;
		}
		
		while(!st.empty()){
			list.add((Integer) st.peek()) ;
		
			st.pop();
		}
		return list;
    }
    */
	//·¨¶þ£ºµÝ¹é
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		
			 backward(list,listNode);
	
		return list;
   }
	private void backward(ArrayList<Integer> list, ListNode listNode) {
		// TODO Auto-generated method stub
		if(listNode!=null){
		    backward(list,listNode.next);
		    list.add(listNode.val);
		 
		}
		
	}

}
