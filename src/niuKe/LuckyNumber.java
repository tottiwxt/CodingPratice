package niuKe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import NetEase.FindJobs;

public class LuckyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int count = 0;
        for(int i = start;i<=end;i++){
        	if(find(i)==true)
        		count++;
        }
        System.out.println(count);
     }

	private static boolean find(int i) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>() ;
		while(i!=0){
			if(set.add(i%10)==false)
				return false;
			i = i/10;
		}
		return true;
	}
	
}
