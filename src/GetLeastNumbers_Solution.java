import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GetLeastNumbers_Solution {

	/**
	 * @param args
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		 Arrays.sort(input);
		 ArrayList<Integer> res = new ArrayList<Integer>();
		 for(int i = 0 ; i<4; i++)
			 res.add(input[i]);
		 return res;
	    
	    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
