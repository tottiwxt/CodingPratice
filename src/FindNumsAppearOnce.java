import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class FindNumsAppearOnce {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        
		Map map = new HashMap<Integer,Integer>();
		for(int i = 0;i<array.length;i++){
			if(map.containsKey(array[i]))
				map.remove(array[i]);
			else{
				map.put(array[i], 1);
			}
		}
		Iterator iterator = map.entrySet().iterator();
		int i =0;
		while(iterator.hasNext()){
			Map.Entry entry = (Entry)iterator.next();
			if(i == 0)
				{num1[0] = (int) entry.getKey();i++;}
			else {
				num2[0] = (int) entry.getKey();
			}
		}

    }
}
