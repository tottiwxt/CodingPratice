import java.util.Stack;


public class Queue_stack {
	   Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public void push(int node) {
	    	while(!stack2.isEmpty()){
	    		stack1.push(stack2.peek());
	    		stack2.pop();
	    	}
	        stack1.push(node);
	    }
	    
	    public int pop() {
	    	while(!stack1.isEmpty()) {
	    		stack2.push(stack1.peek());
	    		stack1.pop();
	    	}
	    	
	    	return stack2.pop();
	    }
}
