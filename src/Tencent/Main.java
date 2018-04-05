package Tencent;

import java.sql.Struct;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	            int len = in.nextInt();
	            int lenA = in.nextInt();
	            int numA = in.nextInt();
	            int lenB = in.nextInt();
	            int numB = in.nextInt();
	            long count = 0;
	            for(int i = 0;i<=len/numA;i++){
	            	for(int j =0 ; j<=len/numB;j++){
	            		if(i*lenA + j*lenB == len){
	            			count += fun(i,numA)*fun(j,numB);
	            		}
	            	}
	            }
//	            for(int i = 0; i<=len/numA;i++){
//	            	int tmpNumb = (len-i*lenA)/lenB;
//	            	if( tmpNumb > numB)
//	            		break;
//	            	for(int j = tmpNumb;j<numB;j++){
//	            		if(i*lenA + j*lenB == len){
//            			count += fun(i,numA)*fun(j,numB);
//            		}
//	            	}
	//            }
	            //System.out.println(fun(5,5));
	            System.out.println(count%1000000007);
	        }
	}

	private static long fun(int i, int numA) {
		// TODO Auto-generated method stub
		long a = 1;
		long b = 1;
		if(i == 0) return 1;
		for(int j = numA;j>numA-i;j--){
			 //被除数
			a=a*j;
			
		}
		for(int j = 1;j<=i;j++){
			 //被除数
			b=b*j;
			
		}
		
		
		
		return a/b;
	}

	

}
