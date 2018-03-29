import java.util.ArrayList;
import java.util.Stack;
public class IsPopOrder {
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
	     Stack<Integer> stack = new Stack<Integer>();
	     int len = pushA.length;
	     int i=0;
	     int j = 0;
	     while(i<len ){
	    	 stack.push(pushA[i]);
	    	 if(pushA[i]==popA[j]){
	    		 stack.pop();
	    		 j += 1;
	    		 while(stack.empty()&&stack.peek()==popA[j]){
	    			 stack.pop();
	    			 j += 1;
	    		 }
	    	 }
	    	 i += 1;
	     }
		  
		 
		 
		 
		 return stack.empty()?true:false;
	    }
}
