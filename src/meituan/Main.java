package meituan;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner  = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			for(int i = 0;i<n;i++){
				int num = scanner.nextInt();
				System.out.println(Length(num));
			}
		}
	}

	private static long Length(int num) {
		// TODO Auto-generated method stub
//		if(num<10)
//			return num;
		int tmp = num;
		int bit = 0;
		while(tmp!=0){
			tmp /= 10;
			bit++;
		}
		long count = 0;
		
//		 count += bit*(num-small+1);
//		 if(small>=10)
//			  count += Length(small-1);
//		return count;
		 while(bit>0){
			 	int small = 1;
				for(int i = 0;i<bit-1;i++){
					small *= 10;
				}
				count += bit*(num-small+1);
				num = small -1;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				bit -= 1;
		 }
		 return count;
	}



}
