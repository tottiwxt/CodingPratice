	package XieCheng;
	
	import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
	public class Main{
	    public static void main(String args[]){
	          Scanner reader=new Scanner(System.in);
	          while(reader.hasNextInt()){
	        	  boolean bool = false;
	        	  int n =reader.nextInt();
	        	  int[][] info = new int[n][3];
	        	  int[] customer = new int[3];
	        	  for(int i = 0 ; i<n ; i++){
	        		  for(int j = 0;j<3;j++){
	        			  info[i][j] = reader.nextInt();
	        		  }
	        	  }
	        	  String str="adsa asd";
	        	  str.split(" ");
	        	  
	        	  for(int i = 0; i<3; i++){
	        		  customer[i]=reader.nextInt();
	        	  }
	        	  //Map<Integer, room> map = new HashMap<Integer,room>();
	        	  for(int i = 0 ; i<n ;i++){
	        		 // System.out.println(info[i][0]+" "+customer[0]+" "+info[i][1]+" "+customer[1]);
	        		  if(info[i][0]>=customer[0]&&info[i][1]>=customer[1])
	        			  {System.out.println(i+","+customer[2]+","+info[i][2]*customer[2]);
	        			  	bool =true;
	        			  }
	        	  }
	        	  if(bool == false){
	        		  System.out.println(-1);
	        	  }
	        		  
	          }
	      
	         // System.out.println(count);
	        
	        	 
	    }
	    
	}
