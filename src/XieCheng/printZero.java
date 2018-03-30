package XieCheng;

import java.util.Scanner;
public class printZero{
    public static void main(String args[]){
          Scanner reader=new Scanner(System.in);
          while(reader.hasNextInt()){
              int n=reader.nextInt();
              int count = 0;
              for(int i = 0; i<n;i++){
            	  int num = reader.nextInt();
            	  if(num==0)	count++;
            	  else {
					System.out.println(num);
				}
              }
              for(int i = 0;i<count;i++){
            	  System.out.println(0);
              }
             
           
          }
    }
}
