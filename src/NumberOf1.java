import java.io.IOException;
import java.util.ArrayList;


public class NumberOf1 {
	 public static int NumberOf1(int n) {
		 int count = 0;
		 int sym = 0;
		 if(n<0) sym =1;
		 
		 ArrayList<Integer> code = new ArrayList<Integer>(32);
		 
	
	
		 
		 //int code[] = {0};
		 if(n>=0){
			 int i =0;
			 while(n>=2){
				 code.add(n % 2) ;
				 n = n/2;
			 }
			 code.add(n);
			 for(int j=code.size()-1;j<32;j++) code.add(0);
		 }
		 else {
			 n = -n;
			 int i =0;
			 while(n>=2){
				 code.add(n % 2) ;
				 n = n/2;
			 }
			 code.add(n);
			 //转为正数的原码
			 for(int j=code.size()-1;j<32;j++) code.add(0);
			 code = reverse(code);
			 code = plusOne(code);
			 
		 }
//		 for(int i = 0; i<code.size();i++)
//			 System.out.print(code.get(i));
//		 //System.out.println("###");
//		 
		 
		 for(int i =0;i<31;i++){
			 //if(i==30) break;
			 if(code.get(i)==1) count++;
			 System.out.print(code.get(i));
		 }
		 
		 //System.out.println(" ");
		 return count+sym;
	    }

	private static ArrayList<Integer> reverse(ArrayList<Integer> code) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<code.size();i++){
			code.set(i, 1-code.get(i));
		}
		return code;
	}

	private static ArrayList<Integer> plusOne(ArrayList<Integer> code) {
		// TODO Auto-generated method stub
		//boolean sym = false;
		
		System.out.println(code.size());
		for(int i=0;i<code.size();i++){
			if(i==code.size()-1){
				code.add(1);
				break;
			}
			if(code.get(i)==0) {
				code.set(i, 1);
				break;
			}
			else if (code.get(i)==1){
				code.set(i, 0);
				//sym = true;
			}
		}
		
		return code;
	}

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//NumberOf1(10);
		//NumberOf1(-10);
		NumberOf1(1);
		
        
	}
}
