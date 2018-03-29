import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.omg.CORBA.TRANSACTION_MODE;


public class Permutation {

	/**
	 * @param args
	 */
	
    public ArrayList<String> Permutation(String str) {
		int len  = str.length();
		ArrayList<String> res = new ArrayList<String>();
		res.add(str);
		//if(len!=1)
			//trans(str,0,res);
    	
    	return null;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> res = new ArrayList<String>();
		res.add("acb");
		res.add("abc");
		res.add("bac");
		Collections.sort(res);
		System.out.println(res);
	}

}
