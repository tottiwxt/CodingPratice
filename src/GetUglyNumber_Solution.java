import java.util.Scanner;


public class GetUglyNumber_Solution {

	/**
	 * @param args
	 */
	 public static int GetUglyNumber_Solution(int index) {
		 	if(index ==0 ) return 0;
		 	int[] ugly = new int[index];
		 	ugly[0] = 1;
		 	// 2*x   3*y  5*z
		 	int x = 0;
		 	int y = 0;
		 	int z = 0;
		 	for(int i = 1;i<index;){
		 		//System.out.println("ugly["+x+"]="+ugly[x]+"   ugly["+y+"]="+ugly[y]+"   ugly["+z+"]="+ugly[z]);
		 		if(2*ugly[x]<=3*ugly[y] && 2*ugly[x]<=5*ugly[z]){
		 			//System.out.println("2 * ugly["+x+"]=【"+2*ugly[x]+"】 <= 3 * ugly["+y+"]=【"+3*ugly[y]+"】   2 * ugly["+x+"]=【"+2*ugly[x]+"】 <5 *ugly["+z+"]= 【"+5 * ugly[z]+"】");
		 			if(ugly[i-1]!=2*ugly[x]){
		 					ugly[i] = 2*ugly[x];
		 					i++;}
		 			
		 			x++;
		 		}
		 		else if(2*ugly[x]>=3*ugly[y] && 3*ugly[y]<=5*ugly[z]){
		 			//System.out.println("2 * ugly["+x+"]=【"+2*ugly[x]+"】>= 3 * ugly["+y+"]=【"+3*ugly[y]+"】   3 * ugly["+y+"]=【"+3*ugly[y]+"】 <=5 *ugly["+z+"]= 【"+5 * ugly[z]+"】");
		 			if(ugly[i-1]!=3*ugly[y]){
		 				ugly[i] = 3*ugly[y];i++;}
		 			y++;
		 		}
		 		else if(2*ugly[x]>=5*ugly[z] && 3*ugly[y]>=5*ugly[z]){
		 			//System.out.println("2 * ugly["+x+"]=【"+2*ugly[x]+"】 >= 5 * ugly["+z+"]=【"+5*ugly[z]+"】   3 * ugly["+y+"]=【"+3*ugly[y]+"】 >=5 *ugly["+z+"]= 【"+5 * ugly[z]+"】");
		 			if(ugly[i-1]!=5*ugly[z]){
		 				ugly[i] = 5*ugly[z];i++;}
		 			z++;
		 		}
		 		
		 	}
		 	
	        return ugly[index-1];
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
        	System.out.println(GetUglyNumber_Solution(in.nextInt()));
        	
        		
        }
		
	}

}
