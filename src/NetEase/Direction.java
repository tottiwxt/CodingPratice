package NetEase;

import java.util.Scanner;

public class Direction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 sc.nextLine();
		 String str = sc.nextLine();
		 
		 int direction = 0;//0北, 1东, 2,南  3,西
		 for(int i = 0; i<n ;i++){

			 if(str.charAt(i) == 'L'){
				 direction -= 1;
				 if(direction<0){
					 direction = 3;
				 }
			 }
			 else if( str.charAt(i) == 'R'){
				 direction += 1;
				 if(direction>3){
					 direction = 0;
				 }
			 }
		 }
		 if(direction == 0)
			 System.out.println("N");
		 else if(direction == 1)
			 System.out.println("E");
		 else if(direction == 2)
			 System.out.println("S");
		 else if(direction == 3)
			 System.out.println("W");
	}

}
