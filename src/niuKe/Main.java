package niuKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import NetEase.FindJobs;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        ArrayList<Integer> weight = new ArrayList<Integer>();
        for(int i = 0 ; i<n ; i++){
        	weight.add(sc.nextInt());
        }
        Collections.sort(weight);//��С����
        int xsum = 0;
        int ysum = 0;
        int xcount = 0;
        int ycount = 0;
        while(!weight.isEmpty()){
        	//System.out.println(weight.get(weight.size()-1));
        	if(xcount==ycount+1){ //��Y��
        		if(ysum <= xsum){ //yС��x
        			
        			ysum += weight.get(weight.size()-1);//y�����
        			weight.remove(weight.size()-1);
        			
        		}
        		else if(ysum > xsum){ //y����x
        			ysum += weight.get(0); //y����С
        			weight.remove(0);
        			
        		}
        		else if(xsum == ysum){
        			ysum += weight.get(weight.size()-1);
        					weight.remove(weight.size()-1);
        					
        		}
        		ycount++;
        	}
        	else if(ycount==xcount+1){//��X��
        		if(xsum > ysum){//x����y
        			
        			xsum += weight.get(0); //x����С
        			weight.remove(0);
        			
        		}
        		else if(xsum < ysum){ //xС��y
        			xsum += weight.get(weight.size()-1); //x�����
        			weight.remove(weight.size()-1);
        			
        		}
        		else if(xsum == ysum){
        			xsum += weight.get(weight.size()-1);
        					weight.remove(weight.size()-1);
        					
        		}
        		xcount++;
        	}
        	else{//��˭����ν
        		if(xsum > ysum){//x����y
        			
        			ysum += weight.get(weight.size()-1); //y�����
        			weight.remove(weight.size()-1);
        			ycount++;
        		}
        		else if(xsum < ysum){ //xС��y
        			xsum += weight.get(weight.size()-1); //x�����
        			weight.remove(weight.size()-1);
        			xcount++;
        		}
        		else if(xsum == ysum){
        			xsum += weight.get(weight.size()-1);
        					weight.remove(weight.size()-1);
        					xcount++;
        		}
        		        	}
        	//System.out.println("size=" +  weight.size());
        }
        System.out.println(xsum<ysum? xsum+" "+ysum : ysum + " "+ xsum);
        
     }

	
	
}
