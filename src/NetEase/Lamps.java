package NetEase;

import java.awt.JobAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lamps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = "";
        for(int i = 0 ;i<n;i++){
        	int length = sc.nextInt();
        		sc.nextLine();
        		str=sc.nextLine();
        		//System.out.println(str.length());
        		int count = 0;
        		double tmp = 0;
        		
        	for(int j = 0 ;j<length;j++){
        		if(str.charAt(j)=='.'&&j!=length-1){
        			tmp++;
        			System.out.println("循环1 tmp="+tmp);
        			if(tmp == 3){
        				count++;
        				tmp = 0;
        				//System.out.println("循环1");
        			}
        		}
        		else if(j == length-1){
        			if(str.charAt(j) == '.'){
        				tmp++;
        				
        			}
        			System.out.println("循环2 tmp="+tmp);
        			count+=Math.ceil(tmp/3);
        			break;
        		}
        		else if(str.charAt(j)=='X'&&str.charAt(j+1)=='X'){
        			//System.out.println("math="+Math.ceil(tmp/3));
        			count += Math.ceil(tmp/3);
        			tmp = 0;
        			
        		}
        		else if(str.charAt(j)=='X'&&str.charAt(j+1)=='.'&&tmp>0)
        			tmp ++;
        		System.out.println("循环3 tmp="+tmp);
        			if(tmp == 3){
        				count++;
        				tmp = 0;
        				//System.out.println("循环3");
        			}
        		
        	}
        	System.out.println(count);
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
