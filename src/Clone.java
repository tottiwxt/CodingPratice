
public class Clone {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	
	 public RandomListNode Clone(RandomListNode pHead)
	    {	//RandomListNode head2 = new RandomListNode(pHead.label);
		   if(pHead == null) return null;
           RandomListNode pHead2 = pHead;
	    	while(pHead2!=null){
	    		RandomListNode node = new RandomListNode(pHead2.label);
	    		node.next = pHead2.next;
	    		pHead2.next = node;
	    		pHead2 = node.next;
	    	}
	    	pHead2 = pHead;
	    	/*while(pHead2.next!=null){
                if(pHead2.random!=null)
	    		     pHead2.next.random = pHead2.random.next;
	    		 
	    		 pHead2 = pHead2.next.next;
	    		 
	    	}*/
	    	while(pHead2!=null){
	    		RandomListNode node = pHead2.next;
	    		if(pHead2.random!=null){
	    			node.random = pHead2.random.next;
	    		}
	    		pHead2 = node.next;
	    	}
	    	RandomListNode res = pHead.next;
	    	pHead2 = pHead;
            RandomListNode tmp = pHead;
	    	while(pHead2.next!=null){
	    			tmp = pHead2.next;
	    			pHead2.next = tmp.next;
                    pHead2 = tmp;
//	    			pHead2.next.next = pHead2.next.next.next;
//	    			pHead2 = pHead2.next;
	    		
	    	}
	    	
	    	return res;
		 
	        
	    }
}
