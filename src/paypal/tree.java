package paypal;

import java.util.ArrayList;
import java.util.Scanner;

import NetEase.FindJobs;



public class tree {
	
	public static class TreeNode {
	    int val = 0;
	    char name  ;
//	    TreeNode left = null;
//	    TreeNode right = null;

	    public TreeNode(char name,int val) {
	        this.val = val;
	        this.name = name;

	    }

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
       
            char targetName = (char) in.nextLine().charAt(0);
            String rootinfo = in.nextLine();
            System.out.println(rootinfo);

            char name = rootinfo.charAt(0);
            int val = rootinfo.charAt(2)-'0';
            TreeNode root = new TreeNode(name,val);
            System.out.println(root.name + " "+ root.val);
            ArrayList<TreeNode> parent = new ArrayList<TreeNode>();
            ArrayList<TreeNode> child = new ArrayList<TreeNode>();
            while (in.hasNext()) {//注意while处理多个case
            	String linkinfo = in.nextLine();
            	  name = linkinfo.charAt(0);
                  val = linkinfo.charAt(2)-'0';
                 parent.add(new TreeNode(name,val)); 
                 name = linkinfo.charAt(5);
                 val = linkinfo.charAt(7)-'0';
                child.add(new TreeNode(name,val)); 
            }

            int res = findnode(root,targetName,parent,child);
         System.out.println(res);
	}

	private static int findnode(TreeNode root, char targetName ,ArrayList<TreeNode> parent,
			ArrayList<TreeNode> child) {
			if(root.name == targetName) return root.val;
			TreeNode finalparent = null;
			int size = parent.size();
			int min = 999999999;
			int count = 0;
			int val = -1;
			for(int i = 0 ; i< size;i++){
				count = 0;
				if(child.get(i).name == targetName){//找到目标名
					finalparent = parent.get(i);
					while(finalparent != root){//找到其深度
						for(int j = 0 ;j<size;j++){
							if(child.get(j)==finalparent){
								finalparent = parent.get(j);
								count++;
								break;
							}
						}
					}
					if(count<min) 
						 val = child.get(i).val;
				}
			}
		
		return val;
	}

}
