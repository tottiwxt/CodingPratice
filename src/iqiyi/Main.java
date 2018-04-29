package iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
        	int category = in.nextInt();
        	int count = in.nextInt();
        	int[][] candy = new int[category][2];
        	boolean bool = true;
        	for(int i = 0;i<category;i++){
        		
        		candy[i][0] = in.nextInt();
        		candy[i][1] = in.nextInt();
        		if(candy[i][0]>count)
        			bool = false;
        	}
        	long res = 0;
        	if(bool!=false)
        		res = DP(category,count,candy,0);
        	System.out.println(res);
        }
        
    }

	private static long DP(int category, int count, int[][] candy, int index) {
		// TODO Auto-generated method stub
		if(count<0) return 0;
		int min = candy[index][0];
		int max = candy[index][1];
		if(min>count)
			return 0;
		long res = 0;
		if(category == 1){
			if(count>max || min>count)
				return 0;
			else{
				return 1;
			}
		}
		for(int i = min;i<=max;i++)
			if(count-i>0)
				res += DP(category-1, count-i, candy, index+1);
		
		return res;
	}

	

}
