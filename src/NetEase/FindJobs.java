package NetEase;

import java.awt.JobAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindJobs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map map = new HashMap<Integer,Integer>();
//        int[] Job= new int[n];
//        int[] Dif= new int[n];
        int[] Money = new int[100001];
       
        
        for(int i = 0 ;i<n;i++){
        	int di = sc.nextInt();
        	int pi = sc.nextInt();
        	map.put(di, pi);
        	if(Money[di]<pi){
        		for(int j = di; j<1000000000; j++){
        			if(Money[j]<pi){
        				Money[j] = pi;
        			}
        			else 
        				break;
        		}
        	}
        	
        }
        for(int i = 0; i < m; i++){
        	int man = sc.nextInt();
        	System.out.println(Money[man]);
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
