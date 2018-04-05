package Tencent;

import java.util.Scanner;

public class reverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	            int n = in.nextInt();
	            int m = in.nextInt();
	            int count =  m;
	            int reverse = -1;
	            int sum = 0;
	            for(int i = 1;i<=n;i++){
	            	if(count > 0){
	            		sum += reverse*i;
	            		count--;
	            	}
	            	else if(count == 0){
	            		reverse = reverse*-1;
	            		sum+= reverse*i;
	            		count = m-1;
	            	}
	            }
	            System.out.println(sum);
	        }
	}

}
