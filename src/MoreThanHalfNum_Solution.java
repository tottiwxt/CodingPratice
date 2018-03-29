import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class MoreThanHalfNum_Solution {
	 public int MoreThanHalfNum_Solution(int [] array) {
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 for(int i = 0 ; i<10; i++)
			 map.put(i, 0);
		 int len = array.length;
		 for(int i = 0; i<len;i++){
			 int count = map.get(array[i])+1;
			 map.put(array[i], count);
			 if(count > len/2)
				 return array[i];
		 }
		 return 0;
	    }
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
		 int[] count = {0,0,0,0,0,0,0,0,0,0};
		
		 
		}

}

