import java.io.IOException;


public class Merge {
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
			
	        ListNode top = list1;
	        ListNode bot = list2;
	        ListNode result = new ListNode(top.val<=bot.val ? top.val:bot.val);
	        if(top.val<=bot.val) top=top.next;
	        ListNode tmp = result;
	        while(!(top==null||bot==null)){
	       
	        	if(top.val<=bot.val){
	        		tmp.next = top;
	        		tmp = tmp.next;
	        		top = top.next;
	        	}
	        	else if(top.val>bot.val){
	        		tmp.next = bot;
	        		tmp = tmp.next;
	        		bot = bot.next;
	        	}
	        	else if (top==null) {
	        		tmp.next = bot;
	        		tmp = tmp.next;
	        		bot = bot.next;
	        	}
	        	else {
	        		tmp.next = top;
	        		tmp = tmp.next;
	        		top = top.next;
	        	}
	        }
	        while(top!=null){
	        	tmp.next = top;
	        	tmp = tmp.next;
        		top = top.next;
	        }
	        while(bot!=null){
	        	tmp.next = bot;
	        	tmp = tmp.next;
        		bot = bot.next;
	        }
	        while(result!=null) {
	        	System.out.print(result.val);
	        	result = result.next;}
		
			return result;
	    }
	
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
       ListNode a1 = new ListNode(5);
       ListNode b1 = new ListNode(6);
       ListNode c1 = new ListNode(7);
       ListNode d1 = new ListNode(8);
       a.next = b;
       b.next = c;
       c.next = d;
       a1.next = b1;
       b1.next = c1;
       c1.next = d1;
       a = Merge(a,a1);
    		
        
	}
}
