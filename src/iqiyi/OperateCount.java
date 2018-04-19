package iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class OperateCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
          int[] x = new int[3];
          for(int i = 0;i<3;i++)
        	  x[i] = in.nextInt();
          
          Arrays.sort(x);
//          for(int i = 0; i<3; i++)
//        	  System.out.println(x[i]);
          int count = 0;
          if((x[1]-x[0])%2==0){
        	  count += (x[1]-x[0])/2;
        	  count += (x[2]-x[1]);
          }
          else {
        	  count += 1+ (x[1]-x[0]-1)/2;
        	  count += (x[2]+1-x[1]);
          }
          System.out.println(count);
        }
    }

	

}
