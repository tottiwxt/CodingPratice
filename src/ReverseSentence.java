import java.util.ArrayList;
import java.util.Arrays;


public class ReverseSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseSentence(" "));
	}

	
	 public static String ReverseSentence(String str) {
	     String[] list = str.split(" "); 
	     if(list.length==0) return str;
		 for(int i = 0,j =list.length-1 ; i<j; i++,j--){
			 String tmp = list[j];
			 list[j] = list[i];
			 list[i] = tmp;
		 }
		 String res = "";
		 int i =0 ; 
		 for( ; i<list.length-1;i++){
			 res = res +list[i] +" ";
		 }
		 res = res+list[i];
		 
		 return res;
	    }
}
