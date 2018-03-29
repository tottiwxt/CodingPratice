import java.util.Stack;
public class miniStack {
	  Stack<Integer> stack = new Stack<Integer>();
	  Stack<Integer> min = new Stack<Integer>();
     public void push(int node) {
        if(stack.empty()){
        	stack.push(node);
        	min.push(node);
        }
        else{
        	stack.push(node);
        	if(node<min.peek()) min.push(node);
        } 
    }
    
    public void pop() {
        if(stack.peek()==min.peek()){
        	min.pop();
        	stack.pop();
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min.peek();
    }
}	
