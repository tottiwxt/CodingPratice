import java.util.ArrayList;
import java.util.Collections;


public class PrintMinNumber {
	 public static String PrintMinNumber(int [] numbers) {
		 int len = numbers.length;
		 ArrayList<String>  str = new ArrayList<String>(len);
		 for(int i =0 ; i<len;i ++){
			 
			 str.add(String.valueOf(numbers[i]));
		 }
		 Collections.sort(str);
		 String res = "";
		 for(int i = 0;i<len;i++){
			 System.out.println(str.get(i));
		 }
		 for(int i = 0 ;i<len-1;i++)
			 for(int j =i+1;j<len;j++)
		 {
			 
			 String sum1 = str.get(i)+ str.get(j);
			 String sum2 = str.get(j)+str.get(i);
			 if(sum1.compareTo(sum2)>0){
				 String tmp = str.get(i);
				 str.set(i, str.get(j));
				 str.set(j, tmp);
			 }
			 
		 }
		 for(int i =0;i<len;i++){
			 res =res + str.get(i);
		 }
//		 System.out.println();
//		 res = res +str.get(len-1);
		 
//			compare(str.get(i),str.get(i+1));
//			 System.out.println(str.get(i));
		 
		 return res;
	    }
	 private static void compare(String str1, String str2) {
		// TODO Auto-generated method stub
		 
		
	}
	public static void main(String args[]){
		 int[] numbers = {3,32,321};
		System.out.println(PrintMinNumber(numbers));
		
	 }
}
