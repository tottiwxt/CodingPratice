import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class JumpFloorII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in) ;
		while(sc.hasNextInt()){
			int num = sc.nextInt();
			System.out.println(JumpFloorII(num));;
		}

	}
	 public static int JumpFloorII(int target) {
	     if(target == 1)
	    	 return 1;
	     else {
	    	 String string = null;
	    	 Map map = new HashMap<Integer, Integer>();
	     }
		 
		 return 0;
	    }
}
