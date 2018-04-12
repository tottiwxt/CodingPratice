package paypal;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case

        	int Target = in.nextInt();
        	int position =  0;
        	int count = 0;
      
        	if(Target > 0)
        		position++;
        	else if(Target < 0)
        		position--;
        	count++;
          	if(Target == 0 ){
        		System.out.println(0);
        	}
          	else if(Target>0){
        		while(position*2<=Target){
        			count++;
        			position = position * 2;
        		}
        		//if(Target-position)
        	}
        	else if(Target<0){
        		while(position*2>=Target){
        			count++;
        			position = position * 2;
        		}
        		System.out.println(count-Target+position);
        	}
        	
        		
        }
    }
}