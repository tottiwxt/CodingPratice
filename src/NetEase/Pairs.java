package NetEase;

import java.util.Scanner;

public class Pairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("n="+n +" k="+k);
		int count = 0;
		for(int y = 1; y<= n ; y++){
			for(int m = 0; m*y<=n-k ; m++){
				for(int kk = k; kk<y;kk++){
					 if(m*y+kk<=n){
						 count++;
						 System.out.println( " " + m*y+kk + " " + y);
					 }
				}
			}
		}
		System.out.println(count);
	}

}
