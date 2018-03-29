import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class FirstNotRepeatingChar {

	/**
	 * @param args
	 */
	 public int FirstNotRepeatingChar(String str) {
	        
		 	Map  map = new LinkedHashMap<>();
	      
	       for(int i = 0;i<str.length();i++){
	    	   char ch = str.charAt(i);
	    	   if(!map.containsKey(ch)){
	    		   map.put(ch, i);
	    	   }
	    	   else{
	    		   if(map.get(ch) != "-1")
	    			   	map.put(ch, "-1");
	    	   }
	    		   
	       }
	       Iterator it = map.entrySet().iterator();
	       while(it.hasNext()){
	    	   Map.Entry entity = (Entry) it.next();
	    	   if(entity.getValue()!="-1")
	    		   return (int) entity.getValue();
	       }
	       
		 
		 return -1;
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}
	
}
