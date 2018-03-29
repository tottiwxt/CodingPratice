import java.util.HashMap;
import java.util.Random;



public class HashMap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 HashMap<Integer,Integer> hash= new HashMap<Integer,Integer>();
		
		 Random rmd = new Random();
		 for (int i=0;i<20;i++){
			   hash.put(i,rmd.nextInt(20));
		 }
		 System.out.println(hash);
	}

}
