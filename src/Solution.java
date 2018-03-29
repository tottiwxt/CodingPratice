import java.io.*;
public class Solution {

	/**
	 * @param args
	 */
	public static void reverse(String x){
		if (x.charAt(0)=='-') {
		   System.out.print('-');
		   for(int i=0;i<x.length()-1;i++){
				if(i == 0 && x.charAt(x.length()-1)== '0')  ;
				else
					System.out.print(x.charAt(x.length()-1-i));
			}
		}
		else 
			for(int i=0;i<x.length();i++){
				if(i == 0 && x.charAt(x.length()-1)== '0')  ;
				else
					System.out.print(x.charAt(x.length()-1-i));
			}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       // String str = null; 
        
        //str = br.readLine(); 
       // reverse(str);
        int[] p = new int[2] ;
        p[0]=12;
        while(p[0]!= 0)   System.out.println(p[0]/2);
       
        
	}

}
