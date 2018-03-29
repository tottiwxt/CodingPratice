
public class TreeDepth {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	 public static int TreeDepth(TreeNode root) {
		 int deepLeft = 1;
		 int deepRight =1;
		 if(root.left == null&&root.right==null)
			 return 1;
		 else if(root.left!=null)
			 deepLeft += TreeDepth(root.left);
		 else if(root.right!=null)
			 deepRight += TreeDepth(root.right);
		
		 
		 
		 return deepLeft>=deepRight?deepLeft:deepRight;
	        
	    }
	 
	 private static void main(String args[]) {
		// TODO Auto-generated method stub
		 TreeNode tree = new TreeNode(1);
		 tree.left = new TreeNode(2);
		 tree.right = new TreeNode(3);
		 //tree = tree.left;
		 tree.left.left = new TreeNode(4);
		 tree.left.right = new TreeNode(5);
		 //tree = tree.right;
		 tree.left.right.left = new TreeNode(6);
		 System.out.println( tree.val);
		 
		 
	}
}
