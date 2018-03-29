import TreeDepth.TreeNode;


public class IsBalanced_Solution {
	public  class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
        	return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        
        if(-1<left-right && left-right<1){
        	return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.left);
        }
        return false;
    }
	public  int TreeDepth(TreeNode root) {
		 int deepLeft = 0;
		 int deepRight =0;
		 if(root == null)
			 return 0;
		
			 deepLeft += TreeDepth(root.left);
		 
			 deepRight += TreeDepth(root.right);
		
		 
		 
		 return deepLeft>=deepRight?deepLeft:deepRight;
	        
	    }
}
