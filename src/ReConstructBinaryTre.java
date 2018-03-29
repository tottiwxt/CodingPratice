
  //Definition for binary tree
 
 
public class ReConstructBinaryTre {
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if(pre.length==0 || in.length == 0 )  {
			 return null;
		 }
		 TreeNode tree=new TreeNode(pre[0]);
		 int index = 0;
		 for(;index<in.length;index++){
			 if(in[index]==pre[0])  {
				 break;
			 }
		 }
		 if(index >= pre.length) return null;
		 int left_length = index;
		 int right_length = pre.length-index-1;
		 
		 
		 int[] pre_l=new int[left_length];
		 int[] in_l = new int[left_length];
		 int[] pre_r= new int[right_length];
		 int[] in_r= new int[right_length];
		 
		 for(int i=0;i<pre.length;i++){
			 if(i<index){
				 pre_l[i]=pre[i+1];
				 in_l[i]=in[i];
			 }
			 else if(i>index){
				 pre_r[i-index-1]=pre[i];
				 in_r[i-index-1]=in[i];
			 }
			 
			 
			 
			 
		 }
		 
		 
		 
		
		 
		 tree.left = this.reConstructBinaryTree(pre_l, in_l);
		 tree.right = this.reConstructBinaryTree(pre_r, in_r);
		 return tree;	     
	    }
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
