package meituan;

import java.util.Scanner;

public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner  = new Scanner(System.in);
		while(scanner.hasNext()){
			int N = scanner.nextInt();
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int p = scanner.nextInt();
			
			int[] A = new int[N];
			A[0] = p;
			for(int i = 1; i<N ; i++){
				A[i] = (A[i-1]+153)%p;
			}
			int result = 0;
			for(int i = 1;i<=n;i++)
				for(int j = 1;j<=m;j++){
					result+= gcd(i,j,A);
				}
			System.out.println(result);
		}
	}

	private static int gcd(int i, int j, int[] A) {
		// TODO Auto-generated method stub
//		int small = i;
//		int gcd = 1;
//		if(i>j)
//			small = j ;
//		else {
//			small = i;
//		}
//		for(int tmp = 1; tmp<=small;tmp++){
//			if((i%tmp==0)&&(j%tmp==0))
//					gcd = tmp;
//		}
		int  yushu = 0;
		if(i>j)
			yushu = i%j;
		else 
			yushu = j%i;
		if(yushu == 0)
			return A[i<j?i-1:j-1];
		else{
			while(yushu!= 0){
				if(i>j)
					i = yushu;
				else
					j = yushu;
				if(i>j)
					yushu = i%j;
				else 
					yushu = j%i;
			}
			return A[i<j?i-1:j-1];
			
		}
		
		
	}

}
