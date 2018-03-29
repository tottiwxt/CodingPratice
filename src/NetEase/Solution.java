package NetEase;

import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	            int n = in.nextInt();
	            int k = in.nextInt();
	            System.out.println(find(n,k));
	            
	        }
	}

	private static int find(int n, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 1 ; i<=n ;i++)
			for(int j =1; j<=n; j++){
				if(i%j>=k)
					count++;
			}
		return count;
	}
	
}
