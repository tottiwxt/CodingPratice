
public class HasSubTree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		 boolean bool = true;
		 
			 if(root1.val == root2.val ){
				 bool = equal(root1,root2);
				 if(bool) return true;
			 }
			 if(root1.left!=null){
			 bool = HasSubtree(root1.left,root2);
			 if(bool == false) return false;
			 } 
			 if(root2.left!=null){
			 bool = HasSubtree(root1.right,root2);
			 if(bool == false) return false;
			 }
		 return false;
	        
		 
	    }
	private boolean equal(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		if(root2 == null) {
			return true;
		}
		if(root1 == null) {
			return false;
		}
		if(root1.val != root2.val) {
			return false;
		}
		boolean bool = true;
		
		if(root1.left!=null && root2.left!=null)
		bool = equal(root1.left,root2.left);
		 if(!bool) return false;
		 if(root1.right!=null&&root2.right!=null)
		bool = equal(root1.right,root2.right);
		  if(!bool) return false;
		
		return true;
	}
}
