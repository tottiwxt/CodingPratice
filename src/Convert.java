import java.net.ConnectException;


public class Convert {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	public TreeNode Convert(TreeNode pRootOfTree) {
		
		   if(pRootOfTree == null) return null;

			TreeNode left = Convert(pRootOfTree.left);
			TreeNode right = Convert(pRootOfTree.right);
	        if(left!=null)
	            while(left.right!=null) left = left.right;
	        if(right!=null)
	            while(right.left!=null) right = right.left;
			
			
			
	       
			if (left != null){           
				left.right = pRootOfTree;
				pRootOfTree.left = left;
				
			}
			if (right != null) {		
	            right.left = pRootOfTree;		
	            pRootOfTree.right = right;
			}
			
			while(pRootOfTree.left!= null) pRootOfTree=pRootOfTree.left;
			return pRootOfTree;
    }

	
}
