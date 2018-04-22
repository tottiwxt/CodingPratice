package FinTech;

import java.util.Scanner;

import javax.sound.midi.Track;

public class CopyOfMain {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	           int caseNum = in.nextInt();
	           
	           for(int Z = 0 ;Z<caseNum;Z++){
	        	  int n = in.nextInt();
	        	  int k = in.nextInt();
	        	  int[] value = new int[n];
 	        	  for(int i = 0; i<n;i++){
	        		  value[i] = in.nextInt();
	        	  }
 	        
 	        	  System.out.println(getChange(k,n,value)%100000007);
	           }
	        }
	    }

	private static long getChange(int k, int n, int[] value) {
		// TODO Auto-generated method stub
		if(k == 0) return 1;
		if(k < 0) return 0;
		if( n<= 0 ) return 0;
		else 
			return getChange(k-value[n-1], n, value)+getChange(k, n-1, value);
		
	}
}
