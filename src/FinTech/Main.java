package FinTech;
import iqiyi.MaxChildStr;

import java.util.Scanner;

public class Main {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	           int n = in.nextInt();
	           
	           for(int Z = 0 ;Z<n;Z++){
	        	   int houseCount = in.nextInt();
	        	   int[] value = new int[houseCount];
	        	   int  i = 0;
	        	   for( i = 0 ;i<houseCount;i++){
	        		   value[i] = in.nextInt();
	        	   }
	        	   int v1 = MaxValue(value,0,houseCount-2);
	        	   int v2 = MaxValue(value,1,houseCount-1);
	        	   System.out.println(v1>v2?v1:v2);
	        	   
	           }
	        }
	    }

	private static int MaxValue(int[] value, int i, int j) {
		// TODO Auto-generated method stub
		if(j==i) return value[i];
		if(j-i == 1)
			return value[i]>value[j]?value[i]:value[j];
		if(j-i == 2)
			return value[i]+value[j]>value[i+1]?value[i]+value[j]:value[j];
		int v1 = value[i]+ MaxValue(value, i+2, j);
		int v2 = MaxValue(value, i+1, j);
		return v1>v2?v1:v2;
	}
}
