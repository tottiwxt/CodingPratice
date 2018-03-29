import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PrintFromTopToBottom {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode tmp = null;
        if(root == null) return null;
		queue.add(root);
		
	
		while(!queue.isEmpty()){
			list.add(root.val);
			tmp = queue.remove();;
			
			
			if(tmp.left!=null){
				queue.add(tmp.left);
				
			}
			if(tmp.left!=null){
			
				queue.add(tmp.right);
				
			}
			
		}
		
		
		return list;
    }
}
