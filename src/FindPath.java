import java.util.ArrayList;


public class FindPath {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}

    ArrayList<ArrayList<Integer>>  arraylist = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	        if(root==null){
	        	return arraylist;
	        }
	        list.add(root.val);
	        target = target - root.val;
	        if(target == 0 && root.left!=null && root.right!=null)
	        	arraylist.add(list);
	        FindPath(root.left,target);
	        FindPath(root.right,target);
	        list.remove(list.size()-1);
	        	
	        return arraylist;
	    }
}
