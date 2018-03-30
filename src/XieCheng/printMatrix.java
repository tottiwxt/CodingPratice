	package XieCheng;
	
	import java.util.Scanner;
	public class printMatrix{
	    public static void main(String args[]){
	          Scanner reader=new Scanner(System.in);
	          while(reader.hasNextInt()){
	          String num = reader.nextLine();
	          int count = 0;
	          for(int i = 0 ;i<num.length();i++){
	        	  if(num.charAt(i)<='9'&&num.charAt(i)>='0')
	        		  count++;
	          }
	      
	         // System.out.println(count);
	          int[][] matrix = new int[count][count];
	          int j = 0;
	          for(int i = 0 ;i<num.length();i++){
	        	  if(num.charAt(i)<='9'&&num.charAt(i)>='0'){
	        		  matrix[0][j] = num.charAt(i)-48;
	        	  		j++;
	        	  }
	          }
	          for(int i = 1 ;i<count;i++){
	        	 for(int k = 0; k<count;k++){
	        		 matrix[i][k] = reader.nextInt();
	        	 }
	          }
	//          for(int i = 0;i<count;i++)
	//        	  for(int k =0;k<count;k++)
	//        		  System.out.println(matrix[i][k]);
	
	          for(int x=0;x<count;x++){
	        	  for(int y=0;y<count;y++)
	        		  if(y!=count-1)
	        			  System.out.print(matrix[count-1-y][x]+"  "); 
	        		  else if(x!=count-1)
	        			  System.out.println(matrix[count-1-y][x]);
	        		  else if(x==count-1)
	        			  System.out.print(matrix[count-1-y][x]);
	        	  //if(x!=count-1)
	        		  //System.out.println();
	          }
	        	 
	    }
	    }
	}
